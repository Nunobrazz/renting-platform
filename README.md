[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/digital-asset/daml/blob/main/LICENSE)

# renting-platform
This code is a proof of concept (POC) demonstrating the use of two oracles and a simple blockchain-based platform for managing lease agreements. It showcases the integration of **ARC-Oracle** and **MI-Oracle** to automate and manage rent payments and maintenance issues in a blockchain-based rental system.

See [documentation] for details.

[documentation]: https://docs.daml.com/getting-started/installation.html

Please ask for help on [the Daml forum] if you encounter any issue!

[the Daml forum]: https://discuss.daml.com

## Development Quick Start

You need to have [Daml] installed.

[Daml]: https://docs.daml.com

Take a look at the [sandbox.sh](./sandbox.sh) to generate the classes and start a test node. 
The [time.sh](./time.sh) script launches the ARC-Oracle API.  
The [arbitrator.sh](./arbitrator.sh) script launches an arbitrator UI.  
The [user.sh](./user.sh) script launches an User UI. 

