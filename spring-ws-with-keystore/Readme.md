Objectif : Interroger Un Web Service SOAP avec une authentification mutuelle 

Adaptation du Projet soap-over-https-with-client-certificate-authentication disponible à 

https://zoltanaltfatter.com/2016/04/30/soap-over-https-with-client-certificate-authentication/

pré-requis : 

	- git 
	- Java 8+
	- Apache Maven 

```
$ git clone https://github.com/houahidi/spring-soap-mutual-authentication.git
$ cd spring-soap-mutual-authentication/spring-ws-with-keystore
$
```

Start the uefa-service with:

```
$ cd producer
$ mvn clean spring-boot:run  -Dspring.profiles.active=https 
```

#### SoapUI

Import the SoapUI project found in the `soapui` folder

Configure the client certificate (found in the `soapui` folder) in the `SoapUI Preferences -> SSL Settings` with `Keystore` field setting to the path of the `soapui.jks` file and `KeyStore Password` setting to `password`

Make a `getTeamRequest` using the example sending the SOAP message to `https://localhost:8443/uefaeuro2016`


#### java client

Start the client
  - input : code pays (AL | FR )

```
$ cd consumer
$ mvn clean spring-boot:run -Dspring-boot.run.arguments=AL -Dspring.profiles.active=https
```