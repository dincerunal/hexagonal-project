#!/bin/bash



DASHES="---------------------------------------------" 

echo $DASHES 
echo "-- Start/Stop Kafka "
echo ""

usage() { 
    echo "start kafka : $0 --start " 
    echo "stop  kafka : $0 --stop " 
    echo 
    echo $DASHES 
    exit ;

} 


startKafka() {

    echo $DASHES 
    echo "--- start kafka"
    docker compose up -d

} 


stopKafka() {
    echo $DASHES 
    echo "--- stop kafka"
    docker compose down
} 


case "$1" in
    -h | --help ) 
        usage
        exit
        ;;      
    --start ) 
        startKafka
        shift;
        shift;
        ;;
    --stop ) 
        stopKafka
        shift;
        shift;
        ;;
    * ) 
        usage
        exit
        ;;
esac


