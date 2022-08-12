# spring-kafka-hello-world
Simple kafka hello world with spring boot


# Requirements
Kafka
Zookeeper

You need to have a Kafka and Zookeeper instance running somewhere and reflect it to the properties. We are mapping it here by running it locally on 9092 as a container. 

Run following to start.

# Zookeeper
docker run -d --name zookeeper -p 2181:2181 jplock/zookeeper

# Kafka
docker run -d --name kafka -p 7203:7203 -p 9092:9092 -e KAFKA_ADVERTISED_HOST_NAME=10.4.1.29 -e ZOOKEEPER_IP=10.4.1.29 ches/kafka
