FROM openjdk:11
EXPOSE 8080
ADD target/springboot-volvo-taxcalc.jar springboot-volvo-taxcalc.jar
ENTRYPOINT ["java","-jar","/springboot-volvo-taxcalc.jar"]