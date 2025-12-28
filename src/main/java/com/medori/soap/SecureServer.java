package com.medori.soap;

import com.medori.soap.impl.HelloServiceImpl;
import com.medori.soap.security.UTPasswordCallback;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Secure Server using Apache CXF and WSS4J.
 * 
 * @author Medori42
 */
public class SecureServer {

    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress("http://localhost:8080/ws/helloSecure");

        Map<String, Object> props = new HashMap<>();
        props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());

        factory.getInInterceptors().add(new WSS4JInInterceptor(props));

        factory.create();
        System.out.println("Secure Server started at http://localhost:8080/ws/helloSecure ...");
    }
}
