#!/bin/bash 

if [ $# -eq 0 ]; then
  echo -e "Uploading DAR file..."
  daml ledger upload-dar --host localhost --port 6865 .daml/dist/rentingPlatform-0.1.0.dar;
  
  echo -e "\n\nRuning Initialize script..."
  daml script --ledger-host localhost --ledger-port 6865 --dar .daml/dist/rentingPlatform-0.1.0.dar --script-name Main:initialize --output-file output.json
  
  echo -e "\n\nGenenrating Java code..."
  daml codegen java;

fi
cd arbitratorsAPI;

mvn clean install compile;
jsonfile=$(cat ../output.json)

timeProvider=$(python3 -c "import sys, json; print(json.load(open('../output.json', 'r'))['_1'])")
arbitrator1=$(python3 -c "import sys, json; print(json.load(open('../output.json', 'r'))['_2'])")
operator=$(python3 -c "import sys, json; print(json.load(open('../output.json', 'r'))['_3'])")



mvn exec:java@run-arbitrator -Dexec.args="localhost 6865 $arbitrator1 $operator";

