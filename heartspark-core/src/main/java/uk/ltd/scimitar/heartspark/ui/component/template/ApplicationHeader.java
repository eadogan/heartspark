package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import uk.ltd.scimitar.heartspark.ui.view.LoginView;
import uk.ltd.scimitar.heartspark.ui.view.RegistrationView;

import java.util.List;

import static uk.ltd.scimitar.heartspark.ui.security.SecurityUtil.isAuthenticated;

@SpringComponent
@UIScope
@HtmlImport("styles/app-header-styles.html")
public class ApplicationHeader extends FlexLayout implements AfterNavigationObserver {

    private Button registerButton;
    private Button signInButton;

    public ApplicationHeader(final ApplicationPopupSidebar popupSidebar) {
        initUI(popupSidebar);
    }

    private void initUI(final ApplicationPopupSidebar popupSidebar) {
        setId("header");

        final Button menuButton = new Button(VaadinIcon.MENU.create());
        menuButton.setClassName("hs-menu-button");
        menuButton.addClickListener(e -> popupSidebar.open());

        final Image heartSparkLogoFull = new Image("/image/logo/heartspark_515x193.png", "HeartSpark logo"); // 128 x 48
        heartSparkLogoFull.setWidth("10.666667em");
        heartSparkLogoFull.setHeight("4em");
        heartSparkLogoFull.setClassName("hs-logo-full");
        heartSparkLogoFull.setAlt("HeartSpark logo");

        final Image heartSparkLogoIcon = new Image("/image/logo/heartspark_icon.png", "HeartSpark logo"); // 48 x 48
        heartSparkLogoIcon.setWidth("4em");
        heartSparkLogoIcon.setHeight("4em");
        heartSparkLogoIcon.setClassName("hs-logo-icon");
        heartSparkLogoIcon.setAlt("HeartSpark logo");

        registerButton = new Button("REGISTER");
        registerButton.setIcon(VaadinIcon.SIGN_IN.create());
        registerButton.setIconAfterText(true);
        registerButton.setClassName("hs-header-button");
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_TERTIARY_INLINE);
        registerButton.addClickListener(e -> UI.getCurrent().navigate(RegistrationView.class));

        signInButton = new Button("SIGN IN");
        signInButton.setIcon(VaadinIcon.SIGN_IN.create());
        signInButton.setIconAfterText(true);
        signInButton.setClassName("hs-header-button");
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_TERTIARY_INLINE);
        signInButton.addClickListener(e -> UI.getCurrent().navigate(LoginView.class));

        add(popupSidebar);
        if (isAuthenticated()) {
            add(menuButton);
        }
        add(heartSparkLogoIcon);
        add(heartSparkLogoFull);

        add(registerButton, signInButton);
    }

    @Override
    public void afterNavigation(final AfterNavigationEvent event) {
        final List<String> segments = event.getLocation().getSegments();

        registerButton.setVisible(false);
        signInButton.setVisible(false);

        if (segments.size() > 0) {
            if (segments.get(0).equals("login")) {
                registerButton.setVisible(true);
            } else if (segments.get(0).equals("registration")) {
                signInButton.setVisible(true);
            }
        }
    }

}
