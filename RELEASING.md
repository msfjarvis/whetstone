# Releasing

1. Change the `VERSION_NAME` in root `gradle.properties` to a non-SNAPSHOT version to be released.
2. `git commit -am "chore(release): bump version to X.Y.Z."` (where X.Y.Z is the new version)
3. `git push origin main` to allow CI to build and publish the artifacts
4. `git tag -a X.Y.Z -m "Version X.Y.Z"` (where X.Y.Z is the new version)
5. Update the root `gradle.properties` to the next SNAPSHOT version.
6. `git commit -am "chore(release): start next development iteration"`
7. `git push && git push --tags`
