## Run the Loan Microservice as a Container using Buildpacks

### Step 1: Update configuration in the pom.xml
`<image>
<name>rojcarranza/${project.artifactId}:v1</name>
</image>`
### Step 2: Build image via maven without the need of Dockerfile
`mvn spring-boot:build-image`


#### Step 3: Run the image in the container
`docker run -d -p 8090:8090 rojcarranza/loans:v1`
#### Reference:
https://paketo.io/
https://buildpacks.io/