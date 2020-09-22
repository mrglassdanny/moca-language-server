# MOCA Language Server

Java based implementation of the [Language Server Protocol] for the MOCA language.


## Features

### Intellisense

|   | MOCA  | SQL  | Groovy  |
|---|---|---|---|
| **Completion**  | commands, arguments, functions,  | tables/views, columns, aliases, subqueries,  | imports, classes, methods/functions  |
| **Hover**  | commands, functions  | tables/views, aliases, subqueries  | imports, classes, methods/functions, variables  |
| **Definition Lookup**  | commands, triggers  |   | classes, methods/functions, variables  |
| **Diagnostics**  | errors, warnings  | errors, warnings  | errors, warnings  |
| **Formatting**  | on save, on paste, on type  | on save, on paste, on type  |   |
| **Semantic Highlighting**  | commands, streams(;)  | range(```[select..]```), tables/views  | range(```[[..]]```)  |
| **Signature Help**  | functions  |   | methods/functions  |


### Command Execution

- [x] MOCA Connection
    - [ ] Direct (legacy)
    - [x] HTTP
    - [ ] HTTPS
- [x] MOCA Script Execution
- [x] MOCA Tracing
- [x] MOCA Command/Trigger Lookup


## Configuration Options

- Enable/Disable MOCA Diagnostics
- Enable/Disable MOCA Warning Diagnostics
- Enable/Disable SQL Diagnostics
- Enable/Disable SQL Warning Diagnostics
- Enable/Disable Groovy Diagnostics
- Enable/Disable Groovy Warning Diagnostics
- Enable/Disable SQL Formatting
- Enable/Disable Groovy Formatting
    - Not yet supported
- Enable/Disable Groovy Static Type Checking



## Clients

- [vscode-moca-client]


## Feedback

Create [issue]


## Contribute

- Contact mrglassdanny@gmail.com




[Language Server Protocol]: https://langserver.org
[vscode-moca-client]: https://github.com/mrglassdanny/vscode-moca-client
[issue]: https://github.com/mrglassdanny/moca-language-server/issues