package uk.ltd.scimitar.heartspark.ui.security;

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

    public static boolean isFrameworkInternalRequest(final HttpServletRequest request) {
        final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
        return parameterValue != null
                && Stream.of(ServletHelper.RequestType.values()).anyMatch(r -> r.getIdentifier().equals(parameterValue));
    }

    public static boolean authenticate(final AuthenticationManager authenticationManager,
                                       final String emailAddress,
                                       final String password) {
        final UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(emailAddress, password);
        try {
            final Authentication auth = authenticationManager.authenticate(authReq);
            final SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (BadCredentialsException e) {
            return false;
        }

        return true;
    }

    public static boolean hasRole(final String role) {
        final SecurityContext sc = SecurityContextHolder.getContext();
        return sc.getAuthentication().getAuthorities().stream()
                .anyMatch(ga -> ga.getAuthority().equals(role));
    }

    public static boolean isAuthenticated() {
        return hasRole("USER");
    }

}
