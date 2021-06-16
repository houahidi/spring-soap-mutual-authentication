mvn clean package spring-boot:run  -Dspring.profiles.active=https# SOAP over HTTPS with client certificate authentication

```
$ cd spring-ws-with-keystore
$
```

Start the uefa-service with:

```
$ cd producer
$ mvn clean package spring-boot:run  -Dspring.profiles.active=https 
```

#### SoapUI

Import the SoapUI project found in the `soapui` folder

Configure the client certificate (found in the `soapui` folder) in the `SoapUI Preferences -> SSL Settings` with `Keystore` field setting to the path of the `soapui.jks` file and `KeyStore Password` setting to `password`

Make a `getTeamRequest` using the example sending the SOAP message to `https://localhost:8443/uefaeuro2016`


#### java client

Start the client with

```
$ cd consumer
$ mvn clean package spring-boot:run -Dspring-boot.run.arguments=AL -Dspring.profiles.active=https
```