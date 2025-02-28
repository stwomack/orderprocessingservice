# OrdersWorkflow
#### Represents 4 REST services that each fail 20% of the time, along with a simple web app that kicks off workflow instances
* If running both services on localhost, start this app as follow and hit http://localhost:8008 in a browser:
    * ```./mvnw spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8080 -Dordersworkflow-url=http://localhost:8081/'```
* New workflow instances are kicked off via the web page of this service app now
