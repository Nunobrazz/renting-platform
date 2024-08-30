#!/bin/bash 

cd User;
mvn clean install compile;

if [ $1 -eq 1 ] 
then 
  user=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['bob'])");
else 
  user=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['alice'])");
fi

public=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['public'])");
mvn exec:java@run-user -Dexec.args="localhost 6865 $user $public";




