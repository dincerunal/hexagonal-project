#!/bin/bash



DASHES="---------------------------------------------" 

echo $DASHES 
echo "-- Start Consumer Aplication "
echo ""

rootDirectory=$PWD 
consumerAppDirectory="$rootDirectory/sensor-app/"

echo "project directory      : $rootDirectory" 
echo "consumer app directory : $consumerAppDirectory" 

startConsumerApp() { 
    cd $consumerAppDirectory; 
    mvn exec:java -Dexec.mainClass="com.dincerunal.app.SensorConsumerApplication"
}


startConsumerApp