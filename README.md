# quarkus-rest-poc

## Create rest-server project
    mvn io.quarkus:quarkus-maven-plugin:1.13.3.Final:create \
        -DprojectGroupId=com.sb \
        -DprojectArtifactId=rest-server \
        -DclassName="com.sb.restserver.ShifumiResource" \
        -Dpath="/play" \
        -Dextensions="resteasy,resteasy-jackson"
    
## Run rest-server
    
    cd rest-server
    ./mvnw compile quarkus:dev

## Test rest-server

    curl -X POST http://localhost:8080/play
    
## Building a native executable

    ./mvnw package -Pnative