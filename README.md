# Hexagonal Project

This repository provides a starter layout, recommended tasks, and instructions to build, test, and run a Java project organized with the Hexagonal (Ports & Adapters) architecture.

Overview
--------
Hexagonal architecture (also called Ports & Adapters) separates the core domain logic from external concerns (frameworks, persistence, UI, etc.) using ports (interfaces) and adapters (implementations). This repository is intended as a starter template to organize domain, application, and adapter code in a maintainable way.

Prerequisites
-------------
- Java 17 or newer
- Maven 3.6+ (or use the project Maven wrapper if included)
- Git

Recommended project layout
--------------------------
- src/main/java — application and domain code
- src/test/java — unit and integration tests
- adapters/ — external adapters (persistence, web, messaging, CLI, etc.)
- scripts/ — helper shell scripts
- pom.xml — Maven build file

Build and run (Maven)
---------------------
1. Build and package:
```sh
mvn -B clean package
```

2. Run tests:
```sh
mvn test
```

3. Package without tests:
```sh
mvn -DskipTests package
```

4. Run the Kafka 

```sh
./runKafka.sh --start
```

5. Run Consumer and Producer app

```sh
./startConsumer.sh
```

```sh
./startProducer.sh
```
Adjust the artifact file name above to match the `artifactId`/`version` declared in your `pom.xml`. If you use Spring Boot, Quarkus, or another framework, update the run instructions accordingly.

Development workflow
--------------------
- Create a branch for each feature or fix:
```sh
git checkout -b feat/short-description
```
- Make small, focused commits and include tests for new behavior.
- Push your branch and open a pull request:
```sh
git push -u origin feat/short-description
```

Testing and quality
-------------------
- Keep unit tests fast and isolated; place them in `src/test/java`.
- Add a small set of integration tests for adapter behavior.
- Consider adding static analysis and formatting tools (Checkstyle, Spotless, PMD) to enforce consistency.

Contributing and support
------------------------
See CONTRIBUTING.md for contribution guidelines. Open an issue or pull request if you need help or want to propose changes.

License
-------
This project is released under the MIT License. See the LICENSE file for details.