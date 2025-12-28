package com.medori.soap.impl;

import com.medori.soap.api.HelloService;
import jakarta.jws.WebService;

/**
 * Implementation of the {@link HelloService} interface.
 * <p>
 * detailed implementation logic for the Hello service.
 * </p>
 * 
 * @author Medori42
 */
@WebService(endpointInterface = "com.medori.soap.api.HelloService", targetNamespace = "http://api.soap.medori.com/")
public class HelloServiceImpl implements HelloService {

    /**
     * {@inheritDoc}
     */
    @Override
    public String sayHello(String name) {
        return "Hello " + name + ", welcome to Medori42 SOAP Service!";
    }
}
