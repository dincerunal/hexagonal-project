# Contributing

Thank you for considering a contribution to this project. This document explains the preferred workflow and guidelines to make contributions easy to review and merge.

Getting started
---------------
1. Fork the repository (or create a branch if you have push access).
2. Create a descriptive branch:
```sh
git checkout -b feat/short-description
```
3. Implement your changes and add tests for any new behavior.
4. Commit with clear, conventional messages (e.g., `feat:`, `fix:`, `chore:`).
5. Push your branch and open a Pull Request describing the changes.

Branch naming
-------------
- feat/… — for new features
- fix/… — for bug fixes
- docs/… — for documentation changes
- chore/… — for maintenance tasks

Commit messages
---------------
- Keep commits small and focused.
- Use imperative, present-tense messages, e.g. `feat: add user registration use-case`.
- Describe the reason for the change, not just what changed.

Pull Request checklist
----------------------
- [ ] The code builds successfully and tests pass locally.
- [ ] New behavior is covered by tests.
- [ ] Documentation updated if behavior or public API changed.
- [ ] PR description explains the context and what was changed.

Code style and tests
--------------------
- Prefer clear and maintainable code over clever optimizations.
- Keep methods small and single-responsibility.
- Write unit tests for domain logic; use integration tests sparingly for adapter behavior.
- Readability and consistency matter—consider adding a formatter or linter to the project.

Review process
--------------
- Maintainters will review PRs and may request changes.
- Address feedback and update your branch; maintainers may squash commits when merging.

License
-------
By contributing, you agree that your contributions will be licensed under this repository’s license (see LICENSE).