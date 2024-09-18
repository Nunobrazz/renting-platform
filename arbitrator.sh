#!/bin/bash 

cd Arbitrators;
mvn clean install compile;

if [ $1 -eq 2 ] 
then 
  arbitrator=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['arbitrator2'])");
else 
  arbitrator=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['arbitrator1'])");
fi

mvn exec:java@run-arbitrator -Dexec.args="localhost 6865 $arbitrator";




