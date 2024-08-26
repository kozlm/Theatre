# Theatre Application

Simple theatre REST API made with Java Spring, Spring Boot, Maven,
JPA with Microsoft SQL Server
and Swagger API documentation.

## Functionality

Application allows you to create, modify, remove and check Client,
Event, Play, Ticket and Hall instances. Dto objects are validated using
Hibernate Validator. All the exceptions are handled with Exception
Handlers.

It's rather basic so far, but it's going to get more complex in the future.

## Installation
1. Clone the repository and go to the project directory:
   ```bash
   git clone https://github.com/your-username/theatre-application.git
   cd theatre
    ```
2. Configure [application properties sample file](src/main/resources/application.properties-sample) 
with your MS SQL database information and change its name to `application.properties`.
3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

## How to use

You can send HTTP requests to `http://localhost:8080`
using your own tool or using Swagger API.


### API Documentation
Detailed API documentation is available via Swagger. 
Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

### HTTP request example

```http request
POST http://localhost:8080/clients
Content-Type: application/json

{
  "name": "asdf",
  "surname": "asdf",
  "gender": "MALE",
  "phoneNumber": "123456789",
  "email": "asdf@asdf.com",
  "password": "asdf"
}
```

## To-Do
- Add JWT-based security 
- Expand Swagger documentation
- Add validation exception messages
- Add tests
