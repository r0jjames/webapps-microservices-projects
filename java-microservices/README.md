### Run the service/project in order
1. Config Server
2. Eureka Server
3. Microservices - Accounts, Loans and Cards
4. Gateway Server
### Java-Spring-Microservices
Port 8080: 
    Service: Accounts Microservice
    URL: http://localhost:8080/swagger-ui/index.html

Port 8090:
    Service: Loans Microservice
    URL: http://localhost:8090/swagger-ui/index.html

Port 9000: 
    Service: Cards Microservice
    URL: http://localhost:9000/swagger-ui/index.html

Port: 8071:
    Service: Config Server
    URL(s):
        - http://localhost:8071/accounts/default
        - http://localhost:8071/accounts/qa
        - http://localhost:8071/accounts/prod
        - http://localhost:8071/cards/default
        - http://localhost:8071/cards/qa
        - http://localhost:8071/cards/prod
        - http://localhost:8071/loans/default
        - http://localhost:8071/loans/qa
        - http://localhost:8071/loans/prod
    GIT: https://github.com/r0jjames/project-config

Port: 8070:
    Service: Eureka Server
    URL(s):
        - http://localhost:8070/
        - http://localhost:8070/eureka/apps

## External Resources:

### To run MYSQL using docker

`
docker run -d -p 3306:3306 --name accountsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=accountsdb mysql
docker run -d -p 3307:3306 --name loansdb -e MYSQL_ROOT_PASSWORD=root  -e MYSQL_DATABASE=loansdb mysql
docker run -d -p 3308:3306 --name cardsdb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=cardsdb mysql
`

## Actuator
### To Shutdown and deregister from Eureka Server
Accounts: http://localhost:8080/actuator/shutdown
Loans: http://localhost:8090/actuator/shutdown
Cards: http://localhost:9000/actuator/shutdown


## Docker
### To push image to docker hub
To create image: `mvn compile jib:dockerBuild `
`
docker image push docker.io/rojcarranza/accounts:v4
docker image push docker.io/rojcarranza/loans:v4
docker image push docker.io/rojcarranza/cards:v4
docker image push docker.io/rojcarranza/configserver:v4
docker image push docker.io/rojcarranza/eurekaserver:v1
docker image push docker.io/rojcarranza/gatewayserver:v1
`

## Circuit Breaker
### To check the status
`http://localhost:8072/actuator/circuitbreakers`

### To check the events per name
`http://localhost:8072/actuator/circuitbreakerevents?name=accountsCircuitBreaker`

## Rate Limiter
### To test the rate limiter using Apache Bench
#### -n = "number of request", -c = "concurrency, -v ="verbose"
`ab -n 10 -c 2 -v 3 http://localhost:8072/rudzbank/cards/api/build-info`