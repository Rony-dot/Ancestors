From openjdk:11
copy ./target/Ancestors-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]



#FROM maven:3.8.2-jdk-8
#WORKDIR /ancestors-app
#COPY . .
#RUN mvn clean install
#CMD mvn spring-boot:run