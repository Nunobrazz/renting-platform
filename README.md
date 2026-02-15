# Renting Platform

A blockchain-based renting platform proof-of-concept (PoC) built with [Daml](https://daml.com/). This project demonstrates a decentralized lease management system featuring automated rent payments, maintenance issue reporting, and dispute resolution via arbitrators.

## Features

- **Lease Agreements**: Manage rental contracts between landlords and tenants.
- **Time Oracle**: Automates time-dependent actions like rent due dates.
- **Arbitration**: Resolves disputes (e.g., maintenance issues) through designated arbitrators.
- **User Interface**: Java-based clients for users and arbitrators to interact with the ledger.

## Prerequisites

Ensure you have the following installed:

- [Daml SDK](https://docs.daml.com/getting-started/installation.html)
- [Java Development Kit (JDK)](https://openjdk.org/) (Compatible with your Maven setup)
- [Maven](https://maven.apache.org/)
- [Python 3](https://www.python.org/) (Used for fetching party IDs in scripts)

## Getting Started

### 1. Build and Start the Ledger

The `sandbox.sh` script automates the build process, generates Java bindings, and starts the Daml Sandbox (Ledger).

```bash
./sandbox.sh
```

**What this does:**
- Builds the Daml project (`rentingPlatform.dar`).
- Generates Java code from Daml templates into `Time/`, `Arbitrators/`, and `User/` directories.
- Starts the Daml Sandbox with the `Test.Main:initialize` init script.
- Generates `parties.json` containing the IDs of allocated parties.

### 2. Run Components

Open separate terminal windows to run the different components of the system.

#### Time Oracle
Starts the Time Provider service which handles time-based events on the ledger.

```bash
# Run Time Provider 1
./time.sh 1

# Run Time Provider 2
./time.sh 2
```

#### User Client
Runs the client application for tenants and landlords.

```bash
# Run as Bob (Tenant)
./user.sh 1

# Run as Alice (Landlord)
./user.sh 2
```

#### Arbitrator Client
Runs the client application for arbitrators to view and resolve disputes.

```bash
# Run as Arbitrator 1
./arbitrator.sh 1

# Run as Arbitrator 2
./arbitrator.sh 2
```

## Project Structure

- **`daml/`**: Contains the Daml source code (Smart Contracts).
    - `User.daml`: User and Message templates.
    - `Test/Main.daml`: Initialization script and main test definitions.
- **`Time/`**: Java application for the Time Oracle.
- **`Arbitrators/`**: Java application for the Arbitrator interface.
- **`User/`**: Java application for the User interface.
- **`manifests/`**: (If applicable) Deployment manifests.
- **`scripts`**:
    - `sandbox.sh`: Lifecycle management (Build, Codegen, Start).
    - `time.sh`, `user.sh`, `arbitrator.sh`: Launchers for respective Java apps.

## Troubleshooting

- **Parties not found**: Ensure `parties.json` exists in the root directory. It is generated when `daml start` runs (via `./sandbox.sh`).
- **Port conflicts**: The scripts assume the ledger runs on `localhost:6865`. Ensure this port is free.
