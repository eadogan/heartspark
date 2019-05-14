package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import uk.ltd.scimitar.heartspark.ui.component.template.WebsiteTemplate;
import uk.ltd.scimitar.heartspark.ui.security.SecurityUtil;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PageTitle("HeartSpark.singles")
@Route(value = "login", layout = WebsiteTemplate.class)
@HtmlImport("styles/view-login-styles.html")
public class LoginView extends LoginForm {

    @Autowired
    public LoginView(final AuthenticationManager authenticationManager) {

        setId("login-view");

        this.addLoginListener(event -> {
            boolean isAuthenticated = SecurityUtil.authenticate(authenticationManager, event);
            if (isAuthenticated) {
                UI.getCurrent().navigate(ProfilesView.class);
            } else {
                this.setError(true);
            }
        });

    }

}
