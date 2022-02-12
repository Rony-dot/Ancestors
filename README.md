## Idea to satisfy the specification

- ####Postman collection is given with this project; Import that file in post man and run the add request sequentially
    1) Add Address (POST request)
    2) Add Parent (POST request)
    3) Add Child (POST request)
- `Address` will have (street, city, state, zip)
- `Parent` will have (firstName, lastName, zipCode) ; assumed zipCode is unique
- `Child` will have (firstName, lastName, fathersId, mothersId)
- ADD, GET, PUT and DELETE methods to satisfy the requirements `CRUD` (CREATE, RETRIEVE, UPDATE, DELETE) operations.
- The REST API endpoint will be:
    - Request URL (GET) : `/address/{id}` Response Object: `{
      "id": 1,
      "createdAt": "2022-02-10T00:00:00",
      "updatedAt": "2022-02-10T00:00:00",
      "street": "Standford Ave",
      "city": "Los Angeles",
      "state": "CA",
      "zip": "90001"
      }` 
    - Request URL (GET) : `/parents/{id}` Response Object: `{
      "id": 2,
      "firstName": "John",
      "lastName": "Doe",
      "address": {
      "id": 1,
      "createdAt": "2022-02-10T00:00:00",
      "updatedAt": "2022-02-10T00:00:00",
      "street": "Standford Ave",
      "city": "Los Angeles",
      "state": "CA",
      "zip": "90001"
      },
      "createdAt": "2022-02-10T16:24:25.452391",
      "updatedAt": "2022-02-10T16:24:25.453394"
      }`
    - Request URL (GET) : `/chids/{id}` Response Object : `{
      "id": 4,
      "createdAt": "2022-02-10T00:00:00",
      "updatedAt": "2022-02-10T00:00:00",
      "firstName": "Jane",
      "lastName": "Doe",
      "father": {
      "id": 2,
      "firstName": "John",
      "lastName": "Doe",
      "address": {
      "id": 1,
      "createdAt": "2022-02-10T00:00:00",
      "updatedAt": "2022-02-10T00:00:00",
      "street": "Standford Ave",
      "city": "Los Angeles",
      "state": "CA",
      "zip": "90001"
      },
      "createdAt": "2022-02-10T16:24:25.452391",
      "updatedAt": "2022-02-10T16:24:25.453394"
      },
      "mother": {
      "id": 3,
      "firstName": "Mrs John",
      "lastName": "Doe",
      "address": {
      "id": 1,
      "createdAt": "2022-02-10T00:00:00",
      "updatedAt": "2022-02-10T00:00:00",
      "street": "Standford Ave",
      "city": "Los Angeles",
      "state": "CA",
      "zip": "90001"
      },
      "createdAt": "2022-02-10T16:24:51.403985",
      "updatedAt": "2022-02-10T16:24:51.403985"
      }
      }`

## A postman collection can be found in the parent directory

## How to Run

To run in development mode, from the root directory of the project, run
```
mvn clean install
```

This will create runnable jar of the backend. now navigate to the /target dir
```
cd .\target\
```
and run:

```
java -jar .\Ancestors-${your-jar-version}-SNAPSHOT.jar
```


It will run your application in `http://localhost:8080`. The page will be like below.
## Or run by the following method
Run below command from project parent dir
```
mvn spring-boot:run
```


## Further improvements

- Working on DOCKER
- A JSON file input to initialize the database with some demo data while first time running the application