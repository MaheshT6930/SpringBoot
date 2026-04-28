package com.example.pigrest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DocController {

    // Default path (relative to pig-rest). You can override by setting system property
    // -Dpig.doc.path=/absolute/path/to/generated_from_pid.py
    private final String defaultDocPath = "../MyPdf/generated_from_pid.py";

    private Path resolveDocPath() {
        String configured = System.getProperty("pig.doc.path");
        if (configured != null && !configured.isBlank()) {
            return Path.of(configured);
        }
        return Path.of(defaultDocPath);
    }

    @GetMapping(path = "/docs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDocs() {
        try {
            Path p = resolveDocPath();
            if (!Files.exists(p)) {
                return ResponseEntity.badRequest().body("Documentation file not found: " + p.toString());
            }
            List<String> lines = Files.readAllLines(p);
            StringBuilder docText = new StringBuilder();

            // collect comment lines before the '--- Inferred skeletons ---' marker
            for (String l : lines) {
                String t = l.stripLeading();
                if (t.startsWith("# --- Inferred skeletons ---") || t.startsWith("# --- Inferred")) {
                    break;
                }
                if (t.startsWith("# ")) {
                    docText.append(t.substring(2)).append("\n");
                }
            }

            return ResponseEntity.ok().body(new java.util.HashMap<String, String>() {{
                put("text", docText.toString());
            }});
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error reading docs: " + e.getMessage());
        }
    }

    @GetMapping(path = "/skeleton", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> getSkeleton() {
        try {
            Path p = resolveDocPath();
            if (!Files.exists(p)) {
                return ResponseEntity.badRequest().body("Documentation file not found: " + p.toString());
            }
            List<String> lines = Files.readAllLines(p);
            StringBuilder skeleton = new StringBuilder();
            boolean inSkeleton = false;
            for (String l : lines) {
                String trimmed = l.stripLeading();
                if (trimmed.startsWith("# --- Inferred skeletons ---") || trimmed.startsWith("# --- Inferred")) {
                    inSkeleton = true;
                    continue;
                }
                if (!inSkeleton) continue;
                // strip leading comment markers if present
                if (trimmed.startsWith("# ")) {
                    skeleton.append(trimmed.substring(2)).append('\n');
                } else {
                    skeleton.append(l).append('\n');
                }
            }
            String result = skeleton.toString().trim();
            if (result.isEmpty()) result = "(no inferred skeletons found)";
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error reading skeleton: " + e.getMessage());
        }
    }

    @GetMapping(path = "/raw", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> getRaw() {
        try {
            Path p = resolveDocPath();
            if (!Files.exists(p)) {
                return ResponseEntity.badRequest().body("Documentation file not found: " + p.toString());
            }
            String content = Files.readString(p);
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error reading file: " + e.getMessage());
        }
    }
}
