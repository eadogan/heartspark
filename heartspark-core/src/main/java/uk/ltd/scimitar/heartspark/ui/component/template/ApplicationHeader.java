package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

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

        add(popupSidebar, menuButton);
    }

}
