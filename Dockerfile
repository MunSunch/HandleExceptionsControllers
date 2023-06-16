FROM openjdk:18.0.2.1-slim-buster
WORKDIR /app/handle_exceptions_web
COPY ./target/HandleExceptionsControllers-0.0.1-SNAPSHOT.jar ./
CMD java -jar HandleExceptionsControllers-0.0.1-SNAPSHOT.jar