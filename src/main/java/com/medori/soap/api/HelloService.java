package com.medori.soap.api;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 * Service interface for the Hello SOAP service.
 * <p>
 * Defines the contract for the Hello service operations.
 * </p>
 * 
 * @author Medori42
 */
@WebService(targetNamespace = "http://api.soap.medori.com/")
public interface HelloService {

    /**
     * Says hello to the provided name.
     * 
     * @param name The name to greet.
     * @return A greeting message.
     */
    @WebMethod
    String sayHello(@WebParam(name = "text") String name);
}
