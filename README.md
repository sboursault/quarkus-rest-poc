# quarkus-rest-poc

## Create projects
    
    # rest-server
    mvn io.quarkus:quarkus-maven-plugin:1.13.3.Final:create \
        -DprojectGroupId=com.sb \
        -DprojectArtifactId=rest-server \
        -DclassName="com.sb.restserver.ShifumiResource" \
        -Dpath="/play" \
        -Dextensions="resteasy,resteasy-jackson"
    
    # rest client
    mvn io.quarkus:quarkus-maven-plugin:1.13.3.Final:create \
        -DprojectGroupId=com.sb \
        -DprojectArtifactId=rest-client \
        -Dextensions="rest-client,rest-client-jackson"
    
## Run project in dev mode
    
    cd <project>
    ./mvnw compile quarkus:dev

## Test rest-server

    curl -X POST http://localhost:8080/play
    
## Building a native executable

    ./mvnw package -Pnative