package com.zoltanaltfatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptorAdapter;
import org.springframework.ws.context.MessageContext;

@Component
public class LoggingClientInterceptor extends ClientInterceptorAdapter {
	  private static final Logger LOGGER = LoggerFactory.getLogger(LoggingClientInterceptor.class);

	
	
    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
    	LOGGER.info(messageContext.getRequest().toString());
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
    	LOGGER.info(messageContext.getResponse().toString());
        return false;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
    	LOGGER.info(messageContext.getResponse().toString());
        return true;
    }
}
