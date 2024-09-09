# Theatre REST API

Simple theatre REST API made using Java Spring, Spring Boot,
JPA with Microsoft SQL Server, Spring Security with JWT authentication, Maven and 
Swagger API documentation.

## Functionality

Application uses JWT authentication mechanism for implementation of role-based 
access control. JWT secret key and expiration time can be changed in the
[application.properties](src/main/resources/application.properties.example) file.

There are two roles available: **Admin** and **Client**. In order to receive JWT token, 
users have to log in via `/v1/auth/login` endpoint.

### Admin

Admin can create, modify, remove and check Client, Event, Play, Ticket 
and Hall instances. Admin user is not stored in the database. His default login is `admin` and
his default password is also `admin`, although they can be changed in the 
[application.properties](src/main/resources/application.properties.example) file.

### Client

Client can update his information stored in the database, buy and withdraw tickets, as well as fetch
every ticket bought by him so far. Clients can be registered by Admin or by the Client himself
via `/v1/auth/register` endpoint.

### Input validation

DTO objects are validated using Hibernate Validator. Objects returned in responses are serialized to JSON
and the views are customized using Jackson annotations. All the exceptions are handled with Exception
Handlers.

## Installation
1. Clone the repository and go to the project directory:
   ```bash
   git clone https://github.com/kozlm/Theatre.git
   cd theatre
    ```
2. Configure [application properties example file](src/main/resources/application.properties.example) 
with your MS SQL database information and change its name to `application.properties`.
3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

## How to use

You can send HTTP requests to `http://localhost:8080`
using Swagger API or your own API tool.

### API Documentation

Detailed API documentation is available via Swagger. 
Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

### HTTP request example

```http request
POST http://localhost:8080/v1/management/clients
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjbGllQGVudC5jb20iLCJpYXQiOjE3MjU1NDEzMjIsImV4cCI6MTcyNTU0NDkyMn0.Z_Nxzxm-sA8a7CmQQQnXxGcbwtZCLXmfu3NSNw5q7TQ

{
  "name": "asdf",
  "surname": "asdf",
  "gender": "MALE",
  "phoneNumber": "123456789",
  "email": "asdf@asdf.com",
  "password": "asdf"
  "dateOfBirth": "03-12-2004",
  "postalCode": "16-450",
  "roomNumber": "23",
  "buildingNumber": "31",
  "street": "Union",
  "city": "Bristol"
}
```

## To-Do
- ~~Add JWT-based security~~ 
- Expand Swagger documentation
- Add validation exception messages
- Add tests
