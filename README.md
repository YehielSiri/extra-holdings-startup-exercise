# extra-holdings-startup-exercise

# The project
A Spring Boot (v. 3.3.7) application with a REST interface that can "Create", "Load" and "Update" a User Account:
* First Name
* Surname
* Username
* Password

### Extensions:
1. A Swagger UI.
2. Input validations to the REST calls by the Hibernate Validation library.
3. Enable monitoring (metrics) endpoints, especially for Prometheus.
4. Secure the application with a JWT Bearer Token.
5. Support for method security.

### Project's components:
* Java (version 23.0.1)
* Maven (version 3.13.0)
* Spring Boot (version 3.3.7)
* Hibernate ORM core (version 6.5.3.)
* H2 - as a database.


### Code structure
The code is structured in Spring Boot's layered configuration:
* Controller - gets HTTP requests from Clients and maps the request. It processes the handles and calls the server logic.
* Service - performs all the business logic over the data of the database.
* Repository - Storage of the entity beans in the system.
* Entity - app's objects.
