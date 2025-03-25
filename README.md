This project is a Spring Boot application that manages farmers, products, and transactions.It allows farmers to buy products,
and their account balances are updated accordingly.  

Project Structure
entity: Contains the JPA entities (Farmer, Product, Transaction).
repository: Contains the Spring Data JPA repositories for the entities.
service: Contains the service classes (FarmerService, ProductService, TransactionService) that handle the business logic.
controller: Contains the REST controllers (FarmerController, TransactionController) that expose the endpoints.
models: Contains the DTO classes (FarmerDto, ProductDto).

Dependencies
The project uses the following dependencies:  
Spring Boot Starter Web
Spring Boot Starter Data JPA
Spring Boot Starter Validation
PostgreSQL (running on docker)


Setup 
clone the project

setup the datasource 

spring.application.name=inua_mkulima_backend
  
spring.datasource.url=jdbc:postgresql://localhost:5432/inuamkulima
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update



