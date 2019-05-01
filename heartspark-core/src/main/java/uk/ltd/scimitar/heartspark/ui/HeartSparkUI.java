package uk.ltd.scimitar.heartspark.ui;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.scimitar.heartspark.ui.component.template.ApplicationHeader;

@SpringComponent
@UIScope
@Route("")
@HtmlImport("frontend://themes/heartspark-theme.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@Inline(value = "favicon.meta", position = Inline.Position.APPEND)
@PageTitle("HeartSpark.singles")
public class HeartSparkUI extends Div implements RouterLayout {

    @Autowired
    public HeartSparkUI(final ApplicationHeader applicationHeader) {
        add(applicationHeader);
    }

}
