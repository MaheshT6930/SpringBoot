#!/usr/bin/env python3
"""
pdf_to_py.py

Copy of the project's PDF extractor placed in `MyPdf/` so it can be
run locally against PDFs stored in this folder.
"""

from __future__ import annotations

import argparse
import re
import sys
from typing import List

try:
    from PyPDF2 import PdfReader
except Exception:
    PdfReader = None


def extract_text_from_pdf(path: str) -> str:
    if PdfReader is None:
        raise RuntimeError("PyPDF2 is required. Install with: pip install PyPDF2")
    reader = PdfReader(path)
    parts: List[str] = []
    for page in reader.pages:
        try:
            parts.append(page.extract_text() or "")
        except Exception:
            parts.append("")
    return "\n".join(parts)


def extract_code_blocks(text: str) -> List[str]:
    fence_regex = re.compile(r"```(?:python)?\n(.*?)```", re.S | re.I)
    blocks = [m.group(1).strip() for m in fence_regex.finditer(text)]
    if blocks:
        return blocks
    example_regex = re.compile(r"Example:\s*(?:\n|\r\n)([\s\S]{20,1000})", re.I)
    blocks = [m.group(1).strip() for m in example_regex.finditer(text)]
    return blocks


def infer_descriptions(text: str) -> List[str]:
    patterns = [
        r"write a function to ([^.\n]+)",
        r"create a function that ([^.\n]+)",
        r"implement ([^.\n]+)",
        r"write a class that ([^.\n]+)",
    ]
    descs: List[str] = []
    for p in patterns:
        for m in re.finditer(p, text, re.I):
            desc = m.group(1).strip()
            if desc:
                descs.append(desc)
    return descs


def make_name_from_description(desc: str) -> str:
    desc = desc.lower()
    desc = re.sub(r"[^a-z0-9\s]", "", desc)
    words = desc.split()
    words = [w for w in words if len(w) > 1][:6]
    if not words:
        return "generated_function"
    return "_".join(words)


def build_skeletons_from_descriptions(descs: List[str]) -> str:
    out_lines: List[str] = [
        "\"\"\"Auto-generated skeletons from PDF instructions.\n",
        "Fill in the implementations where marked.\"\"\"\n",
    ]
    for desc in descs:
        name = make_name_from_description(desc)
        out_lines.append(f"def {name}(*args, **kwargs):")
        out_lines.append(f"    \"\"\"{desc}.\n")
        out_lines.append("    TODO: implement this function based on the PDF description.")
        out_lines.append("    \"\"\"")
        out_lines.append("    raise NotImplementedError()\n")

    if not descs:
        out_lines.append("def main():")
        out_lines.append("    \"\"\"Entry point. Implement program logic here.\"\"\"")
        out_lines.append("    pass\n")
        out_lines.append("if __name__ == '__main__':")
        out_lines.append("    main()\n")

    return "\n".join(out_lines)


def write_output_file(path: str, content: str) -> None:
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)


def create_commented_template(original_text: str) -> str:
    header = [
        "# Auto-generated template from PDF (original text below as comments)",
        "# Review and implement the TODOs.\n",
    ]
    snippet = original_text.strip()[:4000]
    for line in snippet.splitlines():
        header.append("# " + line)
    header.append("\n")
    header.append("# --- Inferred skeletons ---\n")
    return "\n".join(header)


def main(argv=None):
    parser = argparse.ArgumentParser(description="Extract code or generate Python skeletons from a PDF.")
    parser.add_argument("pdf", help="Path to input PDF")
    parser.add_argument("-o", "--output", default="output.py", help="Output Python file")
    parser.add_argument("--no-comments", action="store_true", help="Do not include extracted text as comments")
    args = parser.parse_args(argv)

    try:
        text = extract_text_from_pdf(args.pdf)
    except Exception as e:
        print(f"Error reading PDF: {e}", file=sys.stderr)
        sys.exit(2)

    code_blocks = extract_code_blocks(text)
    if code_blocks:
        combined = "\n\n# --- Code blocks extracted from PDF ---\n\n".join(code_blocks)
        content = combined
        if not args.no_comments:
            content = "# Extracted from PDF\n\n" + content
        write_output_file(args.output, content)
        print(f"Wrote {len(code_blocks)} code block(s) to {args.output}")
        return

    descs = infer_descriptions(text)
    body = build_skeletons_from_descriptions(descs)
    if not args.no_comments:
        comments = create_commented_template(text)
        content = comments + "\n" + body
    else:
        content = body

    write_output_file(args.output, content)
    print(f"Wrote inferred Python template to {args.output}. Found {len(descs)} description(s).")


if __name__ == "__main__":
    main()
