package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
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
public class LoginView extends Div {

    @Autowired
    public LoginView(final AuthenticationManager authenticationManager) {

        setClassName("card");

        final FlexLayout welcomeTextLayout = new FlexLayout();
        welcomeTextLayout.setId("welcome");

        add(welcomeTextLayout);

        final Paragraph title = new Paragraph("Welcome back!");
        title.setClassName("text-large");

        final Paragraph subtitle = new Paragraph("Sign in to your account");
        subtitle.setClassName("text-small");

        welcomeTextLayout.add(title, subtitle);

        final FormLayout formLayout = new FormLayout();
        add(formLayout);

        final EmailField emailAddress = new EmailField();
        emailAddress.setWidth("100%");
        emailAddress.setRequiredIndicatorVisible(true);
        emailAddress.setPlaceholder("Email address");
        emailAddress.setPrefixComponent(new Icon(VaadinIcon.MAILBOX));

        formLayout.add(emailAddress);

        final PasswordField passwordField = new PasswordField();
        passwordField.setWidth("100%");
        passwordField.setRequiredIndicatorVisible(true);
        passwordField.setRequired(true);
        passwordField.setPlaceholder("Password");
        passwordField.setPrefixComponent(new Icon(VaadinIcon.LOCK));

        formLayout.add(passwordField);

        final Button signInButton = new Button("SIGN IN");
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        signInButton.addClickListener(e -> {
            boolean isAuthenticated = SecurityUtil.authenticate(authenticationManager,
                    emailAddress.getValue(), passwordField.getValue());
            if (isAuthenticated) {
                UI.getCurrent().navigate(ProfilesView.class);
            }
        });

        formLayout.add(signInButton);

        final Button forgottenPassword = new Button("Forgotten password");
        forgottenPassword.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE, ButtonVariant.LUMO_SMALL);

        formLayout.add(forgottenPassword);
    }

}
