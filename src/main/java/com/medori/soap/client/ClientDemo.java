package com.medori.soap.client;

import com.medori.soap.api.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import com.medori.soap.security.UTPasswordCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Client to demonstrate consuming the Secure SOAP Service.
 * 
 * @author Medori42
 */
public class ClientDemo {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(HelloService.class);
        factory.setAddress("http://localhost:8080/ws/helloSecure");

        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.USER, "Medori42");
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());

        factory.getOutInterceptors().add(new WSS4JOutInterceptor(props));

        HelloService client = (HelloService) factory.create();
        String response = client.sayHello("User");
        System.out.println("Response: " + response);
    }
}
