package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
@HtmlImport("styles/app-header-styles.html")
public class ApplicationHeader extends FlexLayout {

    public ApplicationHeader() {
        initUI();
    }

    private void initUI() {
        setId("header");
        add(new Label("Header"));
    }

}
