# Instructions to run Microservice in Docker using Google JIB
### Step 1: Add jib-maven-plugin in POM.xml
`<plugin>
<groupId>com.google.cloud.tools</groupId>
<artifactId>jib-maven-plugin</artifactId>
<version>3.4.1</version>
<configuration>
<to>
<image>rojcarranza/${project.artifactId}:v1</image>
</to>
</configuration>
</plugin>`

### Step 2: Build the container image directly to Docker daemon with this maven command:

`mvn compile jib:dockerBuild`

### Step 3: Run Image in the container
`docker run -d -p 9000:9000 rojcarranza/cards:v1
`

### To push to Docker Remote Repository
`docker image push docker.io/rojcarranza/cards:v1`


### To pull from Docker Remote Repository
`docker pull rojcarranza/cards:v1`

#### References:
https://github.com/GoogleContainerTools/jib
https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin
