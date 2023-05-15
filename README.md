# CryptoParser

# RESTful Web-application is written using the following technologies:

- Maven
- Hibernate
- MySQL DB
- Spring Boot
- RestTemplate

### Short description of the project

- Standalone application providing REST API

### Prerequisites:

- Java 20
- Spring Boot 3.0.6
- MySQL

## RESTful API

**1. API Description of general methods for Crypto**

 METHOD | PATH                                 | DESCRIPTION                                          
--------|--------------------------------------|------------------------------------------------------
 GET    | /api/crypt/find/all                  | get all money                                     
 GET    | /api/crypt/getActualCrypt/{id_crypt} | get crypt by id_crypt
 POST   | /api/crypt/save/users/{symbol}       | post user and register their in base with code Crypto           


## Scheduling

**2. API Description of general methods for Crypto**

 METHOD        | DESCRIPTION                                          
---------------|------------------------------------------------------
 postCrypt()   |  parse crypto money from https://www.coinlore.com/cryptocurrency-data-api#3            
 getResult()   |  currency change logger  
