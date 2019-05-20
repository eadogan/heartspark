package uk.ltd.scimitar.heartspark.ui.security.config;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import uk.ltd.scimitar.heartspark.ui.security.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class CustomRequestCache extends HttpSessionRequestCache implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (!SecurityUtil.isFrameworkInternalRequest(request)) {
            super.saveRequest(request, response);
        }
    }

}
