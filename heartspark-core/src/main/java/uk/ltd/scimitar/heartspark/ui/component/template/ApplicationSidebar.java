package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
@HtmlImport("styles/app-sidebar-styles.html")
public class ApplicationSidebar extends Div {

    public ApplicationSidebar() {
        setId("sidebar");
        add(new Label("Sidebar"));
    }

}
