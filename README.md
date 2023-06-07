# Test project for Spring Boot

## About the project

JDK version: 17
maven version: 3.x

## Unit tests

### Run all tests

execute './mvnw test' in the root directory of the project

### Run application

execute './mvnw spring-boot:run' in the root directory of the project

### Test REST API running application

On browser or Postman, using curl command in local system, use this example request:

TEST1: http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14-10.00.00

TEST2: http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14-16.00.00

TEST3: http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14-21.00.00

TEST4: http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-15-10.00.00

TEST5: http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-16-21.00.00