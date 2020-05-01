# Springboot and  Mongo Database integration work

This repository will be containing the topic related to spring-boot, mongodb and examples

 ## Technology and libraries used ##
 
 - [x] JAVA 1.8
 - [x] Springboot 2.2.6-RELEASE
 - [x] MongoDb 
 - [x] Maven build
 - [x] Swagger 2.X (spring-fox)
 - [x] JUnit and Mockito

## How to run this application ##
 * git clone https://github.com/javalingappa/spring-boot-mongo.git
 * get checkout spring-boot-mongo-collections-interactions
 * cd spring-boot-mongo-collections-interactions
 * mvn clean install
 * cd target 
 * java -jar my-mongo-services-1.1.0-SNAPSHOT.jar
 
 ## URL's to launch Swagger and play with APIs ##
 * http://localhost:8080/swagger-ui.html#/  (Swagger API management URL)

 
 ## Tasks Status ##
 
 - [x] API's to generate data for different collections like agent, agentdetail, contact, insured and lossdetails
 - [x] API to create custom consolidated data of all the above based on the agentId in traditional slect and set way (repositories)
 - [x] API to create consolidated data of all the above mentioned collecctions using mongodb Aggregates functionalities
 - [x] Demonustrated Aggregates like $lookup and $unwind
 - [x] Used Mongo database 4.X
 - [x] Swagger for API management
 - [ ] Unit tests 

 