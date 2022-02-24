#!/bin/sh
#Script for building the complete project and building it with docker
build_program(){
    PLACE=$1
    echo "====================Building $PLACE===================="
    (cd $PLACE ; ./mvnw clean package compile ; mkdir target/dependency ; (cd target/dependency; jar -xf ../*.jar) ; docker build --no-cache -t $PLACE:0.0.1 .)
    echo "Is this $PLACE ??"
}

JAVA_VER=$(java -version 2>&1 | sed -n ';s/.* version "\(.*\)\.\(.*\)\..*".*/\1\2/p;')
DOCKER_VER=$(docker-compose --version)

echo "Veryfing Dependencies"
if [[ $JAVA_VER == *"11"* ]] && [[ $DOCKER_VER == *"Docker Compose version"* ]]; then
    echo "Completed"
    else
        echo "There's no Java 11 or Docker Compose installed"
        exit 1
fi

echo "Creating a local image from all microservices"
build_program ms-config-server
build_program ms-discovery
build_program ms-gateway
build_program ms-customer
build_program ms-product
build_program ms-sale

echo "====================EXECUTING DOCKER COMPOSE===================="
docker-compose up -d
