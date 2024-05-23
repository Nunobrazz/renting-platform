#!/bin/bash
cd time-provider;
mvn clean install compile;

mvn exec:java@run-time -Dexec.args="localhost 6865 $(cat ../output.json;)";