
Event Management system
Objective:
A fully functional RESTful API for an Event Booking System where users can browse events, book tickets, and manage their bookings.
Task Description
You are required to build a backend API (no frontend) that supports the following features:
1. User Registration & Authentication
•	User signup with email & password
•	Secure login (JWT or session-based)
•	Role-based access (user, admin)
2. Events Management
•	Admin can create, update, and delete events
•	Anyone (even unauthenticated users) can view events
•	Each event must contain:
o	Title
o	Description
o	Date & Time
o	Location
o	Total Seats
o	Available Seats
3. Booking System
•	Authenticated users can:
o	Book a ticket for an event
o	View their bookings
o	Cancel their bookings
•	The system must:
o	Prevent booking if no seats are available
o	Decrease available seats after booking

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


