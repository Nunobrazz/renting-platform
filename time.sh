#!/bin/bash
if [ $# -eq 0 ]; then 
  echo -e "Uploading DAR file..."
  daml ledger upload-dar --host localhost --port 6865 .daml/dist/rentingPlatform-0.1.0.dar;
  
  echo -e "\n\nRuning Initialize script..."
  daml script --ledger-host localhost --ledger-port 6865 --dar .daml/dist/rentingPlatform-0.1.0.dar --script-name Main:initialize --output-file output.json
  
  echo -e "\n\nGenenrating Java code..."
  daml codegen java;

fi
cd time-provider;

mvn clean install compile;

mvn exec:java@run-time -Dexec.args="localhost 6865 $(cat ../output.json;)";

