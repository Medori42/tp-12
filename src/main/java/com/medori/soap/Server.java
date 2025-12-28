package com.medori.soap;

import com.medori.soap.impl.HelloServiceImpl;
import jakarta.xml.ws.Endpoint;

/**
 * Basic Server to publish the Hello Service.
 * <p>
 * Publishes the service at a local address.
 * </p>
 * 
 * @author Medori42
 */
public class Server {

    public static void main(String[] args) {
        String address = "http://localhost:8080/ws/hello";
        System.out.println("Starting Server at " + address + " ...");
        Endpoint.publish(address, new HelloServiceImpl());
        System.out.println("Server started!");
    }
}
