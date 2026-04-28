# pig-rest

Minimal Spring Boot REST service to serve Pig documentation extracted into `MyPdf/generated_from_pid.py`.

Endpoints:
- `GET /api/docs` — returns JSON `{ "text": "..." }` with the doc text (comment lines before inferred skeletons).
- `GET /api/skeleton` — returns plain-text inferred skeletons extracted from the generated file.
- `GET /api/raw` — returns the raw generated file content.

Build & run

You need Java 17 and Maven installed.

From workspace root:
```bash
cd pig-rest
mvn spring-boot:run
# or build and run the jar
mvn package
java -jar target/pig-rest-0.0.1-SNAPSHOT.jar
```

If the generated file is in a different location, set the system property `pig.doc.path`:
```bash
mvn -Dspring-boot.run.jvmArguments="-Dpig.doc.path=/full/path/to/generated_from_pid.py" spring-boot:run
```
