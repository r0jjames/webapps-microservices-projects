# Java-Spring-Microservices

Port 8080: 
    Service: Accounts Microservice
    Swagger: http://localhost:8080/swagger-ui/index.html

Port 8090:
    Service: Loans Microservice
    Swagger: http://localhost:8090/swagger-ui/index.html

Port 9000: 
    Service: Cards Microservice
    Swagger: http://localhost:9000/swagger-ui/index.html

## External Resources:

### To run MYSQL using docker
AccountsDB: `docker run -d -p 3306:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=accountsdb mysql`
LoansDB `docker run -d -p 3307:3306 --name loansdb -e MYSQL_ROOT_PASSWORD=root  -e MYSQL_DATABASE=loansdb mysql`
CardsDB`docker run -d -p 3308:3306 --name cardsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=cardsdb mysql`