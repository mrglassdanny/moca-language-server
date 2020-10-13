# MOCA Language Server

Cross-platform Java based implementation of the [Language Server Protocol] for MOCA.


## Requirements

- Minimum Java Version: **1.8**


## Features

### Intellisense

|                           | MOCA                              | SQL                                                   | Groovy                                            |
|---------------------------|-----------------------------------|-------------------------------------------------------|---------------------------------------------------|
| **Completion**            | commands, arguments, functions    | tables/views, columns, aliases, subqueries, functions | imports, classes, methods/functions               |
| **Hover**                 | commands, functions               | tables/views, aliases, subqueries, functions          | imports, classes, methods/functions, variables    |
| **Definition Lookup**     | commands, triggers                |                                                       | classes, methods/functions, variables             |
| **Diagnostics**           | errors, warnings                  | errors, warnings                                      | errors, warnings                                  |
| **Formatting**            | on save, on paste, on type        | on save, on paste, on type                            |                                                   |
| **Semantic Highlighting** | commands, streams(```;```)        | range(```[select..]```), tables/views                 | range(```[[..]]```)                               |
| **Signature Help**        | functions                         |                                                       | methods/functions                                 |


### Command Execution

- [x] MOCA Connection
    - [ ] Direct (legacy)
    - [x] http/https
        - [https SSLHandshakeException]
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


## Contribute

Thinking about contributing to the MOCA Language Server?! If you think something is missing or could be improved, please open issues and pull requests. If you'd like to help this project grow, we'd love to have you!


## Contact

- Danny Glass - mrglassdanny@gmail.com



[Language Server Protocol]: https://langserver.org
[vscode-moca-client]: https://github.com/mrglassdanny/vscode-moca-client
[https SSLHandshakeException]: https://stackoverflow.com/questions/9619030/resolving-javax-net-ssl-sslhandshakeexception-sun-security-validator-validatore

