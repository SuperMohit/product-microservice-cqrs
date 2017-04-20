![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/CQRS.png)

1. Product Microservices follows Hexagonal Microservices Architectural Style.
2. The Architecture follows CQRS, Command and Query Responsibility Segregation principle.
3. CQRS pattern is achieved with Axon framework using RabbitMQ as event stream.
4. Product Command Microservice is Command section while Product Query Microservices forms Query section of the CQRS style. 
5. Netflix Eureka is used as discovery server where each of the available Microservices Register.
6. Netflix Zuul is used for API gateway. However, load balancing by Ribbon is disabled.
7. Zuul is also registered with Eureka, so rest of the services registered with Eureka automatically gets routes by Zuul.
8. Spring Cloud Server can be used as Config Server to externalize the configurations. However, in each microservices   configurations are internalized using application.yml or application.properties.
9. H2db is used as in memory db for storing events and domain models.
10. Spring Boot Actuator is added to the path, which provides custom end points for service health information etc.
11. Further monitoring can be enabled using tracing etc by Zipkin etc.
12. Swagger is used in Product Command and Product Query for API documentation.
13. Product Query microservice includes a sample Integration Test.
14. A sample for Global exception handling is availbale in the pacakages.


## Project Workflow:
<br/>

1. Add Product to the system using  rest client(Postman) or using Swagger. Notice the endpoints. Request is made to API Gateway routed to command services name registered with Eureka Server.  


<br/>
2. When product is added to the system, the ProductAddedEvent, is externalized to the RabbitMQ. So, Command service acts as producer of events to the queue.

![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/event-stream.png)

<br/>
3.  The events are further consumed by Query Service.

![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/query.png)


## Containerization using Docker
1. Create a DockerFile in src/main/docker with following entry.
```
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD product-query-0.0.1-SNAPSHOT.jar product-query.jar
RUN sh -c 'touch /product-query.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /product-query.jar" ]
```
2. Add Spotify docker plugin for building the docker image through maven.
```
<properties>
   <docker.image.prefix>springio</docker.image.prefix>
</properties>
<build>
    <plugins>
        <plugin>
            <groupId>com.spotify</groupId>
            <artifactId>docker-maven-plugin</artifactId>
            <version>0.4.11</version>
            <configuration>
                <imageName>${docker.image.prefix}/${project.artifactId}</imageName>
                <dockerDirectory>src/main/docker</dockerDirectory>
                <resources>
                    <resource>
                        <targetPath>/</targetPath>
                        <directory>${project.build.directory}</directory>
                        <include>${project.build.finalName}.jar</include>
                    </resource>
                </resources>
            </configuration>
        </plugin>
    </plugins>
</build>
```
3.  Build a docker image using follwoing command
   ``` mvn package docker:build ```
    
4.  Execute the docker image 
   ``` docker run -p 8180:8180 -t springio/product-query ```





