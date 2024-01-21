# Java MapStruct Demo

Demo project for the [MapStruct](https://mapstruct.org/) code generator with Spring Boot.

MapStruct is a code generator that simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.

This project was created to validate the feasibility of using this library.

This project also uses the H2 Database as in-memory database for testing purpose.

## Requirements

- Java 17
- Spring Boot 3.2.1
- Lombok version 1.18.30
- MapStruct version 1.5.5.Final

## Generating code

To generate the mapping code run the following command:

```shell
mvn clean install
```

## Running the application

To run the application executes the following code:

```shell
mvn spring-boot:run
```

## Accessing the database

Access the database via the following url in your browser: `http://localhost:8080/h2-console`

## Use Cases

### Create a new customer

To create a new customer executes the following command:

```shell
curl --location 'http://localhost:8080/customers' \
--header 'Content-Type: application/json' \
--data '{
    "name": "João da Silva",
    "address": {
        "street": "Rua Um",
        "number": 100,
        "zip_code": 13900100,
        "city": "São Paulo"
    }
}'
```

### Retrieve a customer by id

To retrieve a customer by id executes the following command:

```shell
curl --location 'http://localhost:8080/customers/{{id}}'
```

the `{{id}}` param is the customer id from the create customer request.

### Retrieve a list of customers

To retrieve the list of customers executes the following command:

```shell
curl --location 'http://localhost:8080/customers'
```