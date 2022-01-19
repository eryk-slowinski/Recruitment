# Recruitment project

## Configuring the database
For instructions how to configure DB go to application.properties. There are two ways of connecting: cloud DB or local DB.

## Authorization
Application is secured by basic authorizaton (you have to provide user name and password).
Predefined list of users is located in Globals class.

## Endpoints
Application starts by default on port 8080 and provides 2 endpoints:

Searching without parameters - it returns data of all customers

```bash
http://localhost:8080/calculatetransactions/
```
Searching with parameter - it returns data of choosen customer or customers

```bash
http://localhost:8080/calculatetransactions/getbyid?customer_id=1
http://localhost:8080/calculatetransactions/getbyid?customer_id=1,3,4
```

Or parameter customer_id=all - it returns data of all customers

```bash
http://localhost:8080/calculatetransactions/getbyid?customer_id=all
```

## Unit tests

Application provides few unit tests of endpoint. In order to run them you have to run application first.

#### Via Maven

Open command prompt, go to directory where project is located and type (assuming that you have Maven installed):

```bash
mvn test
```

#### Via IDE

Run class ControllerTest manually.