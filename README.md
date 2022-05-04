# MOCA Language Server

Cross-platform Java based implementation of the [Language Server Protocol] for MOCA.


## Requirements

- Minimum Java Version: **1.8**


## Features

### Intellisense

|                           | MOCA                              | SQL                                                                  | Groovy                                            |
|---------------------------|-----------------------------------|----------------------------------------------------------------------|---------------------------------------------------|
| **Completion**            | commands, arguments, functions    | tables/views, indexes, columns, aliases, subqueries, CTEs, functions | imports, classes, methods/functions               |
| **Hover**                 | commands, functions               | tables/views, aliases, subqueries, CTEs, functions                   | imports, classes, methods/functions, variables    |
| **Definition Lookup**     | commands, triggers                |                                                                      | classes, methods/functions, variables             |
| **Diagnostics**           | errors, warnings                  | errors, warnings                                                     | errors, warnings                                  |
| **Formatting**            | on save, on paste, on type        | on save, on paste, on type                                           |                                                   |
| **Semantic Highlighting** | commands, streams(```;```)        | range(```[select..]```), tables/views                                | range(```[[..]]```)                               |
| **Signature Help**        | functions                         |                                                                      | methods/functions                                 |
| **References**            | commands                          |                                                                      |                                                   |


### Command Execution

- [x] MOCA Connection
    - [ ] Direct (legacy)
    - [x] http/https
        - [Fix https SSLHandshakeException demo]
            - [https SSLHandshakeException StackOverflow thread]
- [x] MOCA Script Execution
    - [x] Approve Unsafe Scripts
- [x] MOCA Tracing
- [x] MOCA Command/Trigger Lookup
- [x] Open MOCA Trace Outline


### Trace Outliner

#### Semantic Highlighting
- Execution Status
- Execution Time
- MOCA Commands
- MOCA Triggers
- Returned Rows
- Command Statement Status
- Component Type
- Thread-Session
- Initiated From Compiled Code

#### Definition Lookup
- .log Definition

#### Hover
- Stack Level
- Execution Status
- Execution Time
- Returned Rows
- Component Type
- Component Level
- Stack Arguments
- Instruction


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

Please refer to the [contribution guide] for specifics.


## Contact

- Danny Glass - mrglassdanny@gmail.com



[Language Server Protocol]: https://langserver.org
[vscode-moca-client]: https://github.com/mrglassdanny/vscode-moca-client
[Fix https SSLHandshakeException demo]: https://vimeo.com/500196466
[https SSLHandshakeException StackOverflow thread]: https://stackoverflow.com/questions/9619030/resolving-javax-net-ssl-sslhandshakeexception-sun-security-validator-validatore
[contribution guide]: https://github.com/mrglassdanny/moca-language-server/blob/master/CONTRIBUTE.md

