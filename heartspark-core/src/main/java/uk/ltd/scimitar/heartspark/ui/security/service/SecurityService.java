package uk.ltd.scimitar.heartspark.ui.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import uk.ltd.scimitar.heartspark.ui.security.SecurityUtil;

import java.io.Serializable;

@Service
public class SecurityService implements Serializable {

    private transient AuthenticationManager authenticationManager;

    public SecurityService(final AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public boolean authenticate(final String emailAddress,
                                final String password) {
        return SecurityUtil.authenticate(authenticationManager,
                emailAddress, password);
    }

}
