# Helix Mathematica

## Environment:
```Oracle Java (JDK jdk1.8.0_151 64-bit)```

### REST API
Push to Queue: ```<server>:<port>/rest/push/[Number 1]/[Number 2]```

List Queue: ```<server>:<port>/rest/list```

### SOAP WSDL
```http://<server>:<port>/ws/mathematica.wsdl```

### Building and running:
Generate a .war by executing the following command in the project folder:
```mvn clean package```
The WAR generated (typically residing in target/*.war) may then be directly deployed onto a Java application server, or it can be packaged in another EAR and then deployed.

### Possible Enhancements:
1.	Log aggregation using Spring Cloud Sleuth in case the service needs to expand horizontally
2.	Netflix Hysterix for fault tolerance/resilience
3.	Netflix Eureka and Netflix Ribbon for service discovery and client configuration

### Database Tables:
1.	Numbers – All numbers added
2.	GCD - All GCD computed

### Assumptions:
1.	Security specification were not provided, hence I assumed that it was regarding HTTPS support which the application server can handle. For interface based security, we would require OAuth2 based on JWT tokens.
2.	The code is production quality, but not exhaustive

### Notes:
1.	The code produces WAR artifact which may be incorporated into an EAR. We can exclude the 
2.	The test written are only for the integrations and trivial as more time is required to cover all layers of the application. TestNG is better for testing concurrent access to the Dequeue
3.	There are a lot of aspects of the application I have not been able to cover due to scarcity of time in delivering this.
4.	Embedded RDMS has been used
