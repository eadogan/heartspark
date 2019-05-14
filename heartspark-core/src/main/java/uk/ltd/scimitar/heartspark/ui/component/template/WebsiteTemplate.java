package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@HtmlImport("frontend://themes/heartspark-theme.html")
@HtmlImport("styles/app-root-styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@Inline(value = "favicon.meta", position = Inline.Position.APPEND)
public class WebsiteTemplate extends Div implements RouterLayout {

    @Autowired
    public WebsiteTemplate(final ApplicationHeader header) {
        add(header);
    }

}
