package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.scimitar.heartspark.email.domain.EmailTemplate;
import uk.ltd.scimitar.heartspark.email.domain.ForgotPasswordEmailParams;
import uk.ltd.scimitar.heartspark.email.service.EmailSenderService;
import uk.ltd.scimitar.heartspark.ui.component.template.WebsiteTemplate;
import uk.ltd.scimitar.heartspark.ui.domain.SignIn;
import uk.ltd.scimitar.heartspark.ui.security.service.SecurityService;

import java.io.IOException;

@SpringComponent
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PageTitle("HeartSpark.singles")
@Route(value = "login", layout = WebsiteTemplate.class)
@HtmlImport("styles/view-login-styles.html")
public class SignInView extends Div {

    private Div error;
    private final EmailSenderService emailSenderService;
    private final SecurityService securityService;

    @Autowired
    public SignInView(final SecurityService securityService,
                      final EmailSenderService emailSenderService) {

        this.securityService = securityService;
        this.emailSenderService = emailSenderService;

        setClassName("card");

        final HorizontalLayout rootLayout = new HorizontalLayout();

        final Binder<SignIn> signInBinder = new Binder<>();
        final SignIn signInBean = new SignIn();

        final Div welcomeTextLayout = new Div();
        welcomeTextLayout.setId("welcome");
        welcomeTextLayout.setWidthFull();

        final Paragraph title = new Paragraph("Welcome back!");
        title.getElement().getStyle().set("font-size", "var(--lumo-font-size-xl)");

        final Paragraph subtitle = new Paragraph("Sign in to your account");
        subtitle.setClassName("text-small");

        final Div bgImageWrapper = new Div();
        bgImageWrapper.setSizeUndefined();

        final Image bgImage = new Image();
        bgImage.setSizeUndefined();
        bgImage.setSrc("image/bglogo.png");
        bgImage.setMaxWidth("400px");

        bgImageWrapper.add(bgImage);

        error = new Div();
        error.addClassNames("error-block", "error-50pct");
        error.add(new H3("Incorrect email address or password"));
        error.add(new Paragraph("Your email address and password do not match any of our accounts. If you have forgotten your password, click on the Forgotten Password link below."));
        error.setVisible(false);

        welcomeTextLayout.add(title, subtitle, bgImageWrapper, error);

        final FormLayout formLayout = new FormLayout();
        formLayout.setWidthFull();
        formLayout.getElement().getStyle().set("line-height", "2rem");

        final Div hsIconWrapper = new Div();
        hsIconWrapper.setSizeUndefined();
        hsIconWrapper.setId("hs-icon-wrapper");

        final Image hsIcon = new Image();
        hsIcon.setSizeUndefined();
        hsIcon.setSrc("image/logo/heartspark_icon_96x96.png");
        hsIcon.setAlt("HeartSpark");

        hsIconWrapper.add(hsIcon);

        final EmailField emailAddress = new EmailField();
        emailAddress.setWidth("100%");
        emailAddress.setPreventInvalidInput(true);
        emailAddress.setRequiredIndicatorVisible(true);
        emailAddress.setPlaceholder("Type your email address");
        emailAddress.setPrefixComponent(new Icon(VaadinIcon.MAILBOX));

        final PasswordField passwordField = new PasswordField();
        passwordField.setWidth("100%");
        passwordField.setRequiredIndicatorVisible(true);
        passwordField.setRequired(true);
        passwordField.setPlaceholder("Type your password");
        passwordField.setPrefixComponent(new Icon(VaadinIcon.LOCK));

        formLayout.add(hsIconWrapper, emailAddress, passwordField);

        final Div buttonLayout = new Div();
        buttonLayout.setWidthFull();
        buttonLayout.setId("button-layout");

        final Anchor forgottenPassword = new Anchor();
        forgottenPassword.setText("Forgot password?");
        forgottenPassword.getElement().addEventListener("click", e -> sendPasswordResetLink(emailAddress));

        final Anchor registerButton = new Anchor();
        registerButton.setText("Register");
        registerButton.getElement().addEventListener("click", e -> UI.getCurrent().navigate(RegistrationView.class));

        buttonLayout.add(forgottenPassword, registerButton);

        final Button signInButton = new Button("SIGN IN");
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        signInButton.addClickListener(e -> signIn(signInBinder, signInBean));

        formLayout.add(buttonLayout, signInButton);

        // Register the form binder
        signInBinder.forField(emailAddress)
                .asRequired("Email address is a required field.")
                .bind(SignIn::getEmailAddress, SignIn::setEmailAddress);
        signInBinder.forField(passwordField)
                .asRequired("Password is a required field.")
                .bind(SignIn::getPassword, SignIn::setPassword);
        signInBinder.setBean(signInBean);

        rootLayout.add(welcomeTextLayout, formLayout);

        add(rootLayout);
    }

    private void signIn(
            final Binder<SignIn> signInBinder,
            final SignIn signInBean) {
        boolean valid = signInBinder.writeBeanIfValid(signInBean);
        if (valid) {
            boolean isAuthenticated = securityService.authenticate(signInBean.getEmailAddress(),
                    signInBean.getPassword());
            if (isAuthenticated) {
                UI.getCurrent().navigate(ProfilesView.class);
            }
            else {
                error.setVisible(true);
            }
        }
    }

    private void sendPasswordResetLink(final EmailField emailAddress) {
        if (emailAddress.getValue().isEmpty()) {
            emailAddress.setErrorMessage("Please type in your email address");
            emailAddress.setInvalid(true);
        }
        else {
            try {
                emailSenderService.sendSimpleMessage(emailAddress.getValue(), "Reset your email",
                        EmailTemplate.FORGOT_PASSWORD, new ForgotPasswordEmailParams());
                Notification.show("An email has been sent to " + emailAddress.getValue(),
                        2000, Notification.Position.BOTTOM_STRETCH);
            }
            catch (final IOException e) {
                // TODO: Notify user this didn't work.
                e.printStackTrace();
            }
        }
    }

}
