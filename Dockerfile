
# Build stage
FROM maven:3.6.3-openjdk-11 AS build
COPY . /usr/pedido
COPY pom.xml /usr/pedido
WORKDIR /usr/pedido
RUN mvn -X clean package -DskipTests

# Package stage
# docker run --rm -it demo:latest
FROM openjdk:11-jre
COPY --from=build /usr/pedido/target/pedidos-0.0.1-SNAPSHOT.war /usr/local/lib
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/pedidos-0.0.1-SNAPSHOT.war"]