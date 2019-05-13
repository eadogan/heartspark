package uk.ltd.scimitar.heartspark.ui.security.config;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import uk.ltd.scimitar.heartspark.ui.security.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomRequestCache extends HttpSessionRequestCache {

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (!SecurityUtil.isFrameworkInternalRequest(request)) {
            super.saveRequest(request, response);
        }
    }

}
