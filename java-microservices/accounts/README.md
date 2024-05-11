# Instructions to run Microservice in Docker using Dockerfile
### Step 1: Run maven command to generate jar file from where the pom.xml
`mvn clean install`

### Step 2: Create a Dockerfile to generate an image

### Step 3: Build Image from the Dockerfile
`docker build . -t rojcarranza/accounts:v1
`
### Step 4: Run Image in the container
`docker run -d -p 8080:8080 rojcarranza/accounts:v1
`

### To push to Docker Remote Repository
`docker image push docker.io/rojcarranza/accounts:v1`
### To pull from Docker Remote Repository
`docker pull rojcarranza/accounts:v1`

## Spring Profiles via Command Line Argument

### Option 1: Program Arguments (HIGHEST PRECEDENCE)
`--spring.profiles.active=prod --build-version=1.1`

### Option 2: JVM Options
`-Dspring.profiles.active=prod -Dbuild-version=1.2`

### Option 3: Environment variables
`SPRING_PROFILES_ACTIVE=prod;BUILD_VERSION=1.3`

