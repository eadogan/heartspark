package uk.ltd.scimitar.heartspark.ui.security;

import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.server.ServletHelper;
import com.vaadin.flow.shared.ApplicationConstants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

public class SecurityUtil {

    public static boolean isFrameworkInternalRequest(HttpServletRequest request) {
        final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
        return parameterValue != null
                && Stream.of(ServletHelper.RequestType.values()).anyMatch(r -> r.getIdentifier().equals(parameterValue));
    }

    public static boolean authenticate(final AuthenticationManager authenticationManager,
                                       final AbstractLogin.LoginEvent event) {
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(event.getUsername(), event.getPassword());
        try {
            Authentication auth = authenticationManager.authenticate(authReq);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (BadCredentialsException e) {
            return false;
        }

        return true;
    }

}
