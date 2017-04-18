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
12. Swagger can be used for API documentation.
13. There are no test cases.


![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/CQRS.png)

Project Workflow:

1. Add Product to the system using  rest client(Postman). Notice the endpoints. Request is made to API Gateway routed to command services name registered with Eureka Server.  

![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/restclient.png)


2. When product is added to the system, the ProductAddedEvent, is externalized to the RabbitMQ. So, Command service acts as producer of events to the queue.
![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/event-stream.png)



3.  The events are further consumed by Query Service.
![ScreenShot](https://github.com/SuperMohit/product-microservice-cqrs/blob/master/query.png)
