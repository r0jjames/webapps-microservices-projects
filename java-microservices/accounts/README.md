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