package com.medori.soap.security;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Callback handler for WSS4J security.
 * <p>
 * Verifies the password for the given username.
 * </p>
 * 
 * @author Medori42
 */
public class UTPasswordCallback implements CallbackHandler {

    private final Map<String, String> passwords = new HashMap<>();

    public UTPasswordCallback() {
        passwords.put("Medori42", "password");
        passwords.put("admin", "admin");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            WSPasswordCallback pc = (WSPasswordCallback) callback;
            String user = pc.getIdentifier();
            String password = passwords.get(user);

            if (password != null) {
                pc.setPassword(password);
                return;
            }
        }
    }
}
