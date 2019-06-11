package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import static uk.ltd.scimitar.heartspark.ui.security.SecurityUtil.isAuthenticated;

@SpringComponent
@UIScope
@HtmlImport("styles/app-header-styles.html")
public class ApplicationHeader extends FlexLayout {

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

        add(popupSidebar);
        if (isAuthenticated()) {
            add(menuButton);
        }
        add(heartSparkLogoIcon);
        add(heartSparkLogoFull);
    }

}
