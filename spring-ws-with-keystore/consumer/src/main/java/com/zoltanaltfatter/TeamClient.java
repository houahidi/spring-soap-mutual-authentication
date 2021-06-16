package com.zoltanaltfatter;

import com.eufa.euro.GetTeamRequest;
import com.eufa.euro.GetTeamResponse;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Zoltan Altfatter
 */
@Slf4j
@Component
public class TeamClient {
	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	 private static final Logger log = LoggerFactory.getLogger(HttpsWebServiceClientConfig.class);

     public TeamClient() {
         log.info("=========TeamClient");
      
    }
	
    public TeamClient( WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public GetTeamResponse getTeamByCountryCode(String countryCode) {
        GetTeamRequest request = new GetTeamRequest();
        request.setCountryCode(countryCode);

        GetTeamResponse response = (GetTeamResponse) webServiceTemplate.marshalSendAndReceive(request);

        log.info("=========received message:" + response);
        return response;
    }
}
