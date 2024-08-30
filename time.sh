cd Time;
mvn clean install compile;

if [ $1 -eq 1 ] 
then 
  timeProvider=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['timeProvider1'])")
else 
  timeProvider=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['timeProvider2'])")
fi

lifecycler=$(python3 -c "import sys, json; print(json.load(open('../parties.json', 'r'))['lifecycler'])")

mvn exec:java@run-time -Dexec.args="localhost 6865 $timeProvider $lifecycler";


