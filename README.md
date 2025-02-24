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
4. Secure the application with a JWT Bearer Token using Spring Boot Security.
5. Support for method security.

### Project's components:
* Java (version 23.0.1)
* Maven (version 3.13.0)
* Spring Boot (version 3.3.7)
* Hibernate ORM core (version 6.5.3.)
* H2 - as a database.
* Infinispian cache - caching app using Infinispan as a Spring Cache provider.
* jjwt (version 0.11.5)


### Code structure
The code is structured in Spring Boot's layered configuration:
* Controller - gets HTTP requests from Clients and maps the request. It processes the handles and calls the server logic.
* Service - performs all the business logic over the data of the database.
* Repository - Storage of the entity beans in the system.
* Entity - app's objects.
* Config - configuration classes.
* Security - app security classes, such as: authentication, authorization, filtering.

# How to use
Run it.

Database UI is accessible through http://localhost:3030/h2-console/. Connect using the string 'sa' as both the username and password.

Swagger UI is accessible through http://localhost:3030/swagger-ui/index.html.

Prometheus Web UI is accessible through http://localhost:3001/. 
This interface is instrumental for executing queries, gazing at gathered metrics, and verifying the status of scrape goals.

### Remains to be done:
1. Caching - moving caching from the service layer to the data layer (repository layer).
2. LOAD operation for USER role - return just the current user profile.
3. Implement 'loadUserByUsername' function from 'UserDetailsService' interface into 'UserAccountServiceImpl' class.
4. Config/SecurityConfig/securityFilterChain - specifically authentication according to ROLE.
5. Service/JwtService/SECRET - replace this with a secure key, ideally fetched from environment variables.
6. entity/UserAccount/roles - check replace it by 'role' and using of the Enum Role. Check also the implications of using this field in the service.
