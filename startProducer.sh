#!/bin/bash

DASHES="---------------------------------------------" 

echo $DASHES 
echo "-- Start Producer Aplication "
echo ""


rootDirectory=$PWD 
producerAppDirectory="$rootDirectory/sensor-app/"

echo "project directory      : $rootDirectory" 
echo "producer app directory : $producerAppDirectory" 

startProducerApp() { 
    cd $producerAppDirectory; 
    mvn exec:java -Dexec.mainClass="com.dincerunal.app.SensorProducerApplication"
}


startProducerApp
