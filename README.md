# Kafka Avro Producer-Consumer
## Overview

The project demonstrates a simple Kafka producer-consumer setup using Avro for message serialization and deserialization. The goal is to illustrate how to:
1. Send a serialized Avro message from a Kafka producer.
2. Receive and deserialize the Avro message in a Kafka consumer.
   
### Avro Schema
Avro relies on a defined schema for serialization and deserialization. 
In this project, Avro schemas define the structure of the messages exchanged between the Kafka producer and consumer. 
The use of Avro schemas allows for schema evolution, ensuring compatibility between different versions of the data.
