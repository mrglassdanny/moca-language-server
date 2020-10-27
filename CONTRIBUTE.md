# Contribute

This document provides information for developers who wish to contribute to the MOCA Language Server project.

## Building

#### Dependencies
Project uses Gradle, so all dependencies are managed via `build.gradle` file in project root directory. Gradle `gradle-wrapper.jar` is packed with the project (`/gradle/wrapper`), so there is no need to make sure Gradle is installed.

#### Clone and build
Once repository is cloned, you can build by running
```powershell
./gradlew build
```
command in project root directory via terminal.

This will generate new `.jar` files in `/build/libs`. `moca-language-server-VERSION-all.jar` is fat jar. Version is dictated in `build.gradle` file.


## Testing

It is recommended to test in conjunction with language client. Supported language clients can be found [here]. Supported clients will possess their own contribution guides. 


## Debugging

Debugging with language client is **not yet configured**.





[here]: https://github.com/mrglassdanny/moca-language-server/blob/master/README.md