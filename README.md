# MoveInSyncTask-2
Event Management system

This project is a Spring Boot REST API for event management, including:
- User registration(ADMIN/USER)
- User login (with session support)
- User logout
- Swagger documentation
- Event booking
- Booking cancellation
- Event adding by admin
- Event deleting by user
---

## Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- MySQL database
- Swagger / OpenAPI (via springdoc)
- Lombok

---

## Project Structure

```bash
src/
├── main/
│   ├── java/
│   │   └── com/app/divyansh/
│   │       ├── controller/          # REST APIs
│   │       ├── model/               # Entity & DTOs
│   │       ├── repository/          # Spring Data JPA
│   │       ├── service/             # Business logic
|   |       |---utility/
│   └── resources/
│       ├── application.properties
| pom.xml
-----
```
To run
./mvnw spring-boot:run

Api link(endpoint)
http://localhost:8081/swagger-ui/index.html#

Database configuration
spring.application.name=EventBookingSystem
server.port=8081
springdoc.swagger-ui.path=/swagger-ui.html

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/divyanshdb
spring.datasource.username=root
spring.datasource.password=divyansh

spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update


