# extra-holdings-startup-exercise

# The project
A Spring Boot (v. 3.3.7) application with a REST interface that can "Create", "Load" and "Update" a User Account:
* ID - for database management.
* FirstName
* Surname
* Username
* Password

### Extensions:
1. A Swagger UI.
2. Input validations to the REST calls by the Hibernate Validation library.
3. Enable monitoring (metrics) endpoints, especially for Prometheus:
   1. Spring Boot application exposes.
   2. Prometheus scrape, collect and store.
   3. Grafna visualizes.
4. Secure the application with a JWT Bearer Token.
5. Support for method security.

### Project's components:
* Java (version 23.0.1)
* Maven (version 3.13.0)
* Spring Boot (version 3.3.7)
* Hibernate ORM core (version 6.5.3.)
* H2 - as a database.
* Infinispian cache - caching.


### Code structure
The code is structured in Spring Boot's layered configuration:
* Controller - gets HTTP requests from Clients and maps the request. It processes the handles and calls the server logic.
* Service - performs all the business logic over the data of the database.
* Repository - Storage of the entity beans in the system.
* Entity - app's objects.

# How to use
Run it.

Database UI is accessible through http://localhost:3030/h2-console/. Connect using the string 'sa' as both the username and password.

Swagger UI is accessible through http://localhost:3030/swagger-ui/index.html.

Prometheus Web UI is accessible through http://localhost:3001/. 
This interface is instrumental for executing queries, gazing at gathered metrics, and verifying the status of scrape goals.

