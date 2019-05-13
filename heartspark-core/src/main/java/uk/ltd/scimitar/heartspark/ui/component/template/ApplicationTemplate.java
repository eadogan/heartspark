package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.scimitar.heartspark.ui.component.element.CircleButton;

@SpringComponent
@UIScope
@HtmlImport("frontend://themes/heartspark-theme.html")
@HtmlImport("styles/app-root-styles.html")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@Inline(value = "favicon.meta", position = Inline.Position.APPEND)
public class ApplicationTemplate extends Div implements RouterLayout {

    private final ApplicationContentRoot applicationContentRoot;

    @Autowired
    public ApplicationTemplate(final ApplicationHeader header,
                               final ApplicationContentRoot contentRoot,
                               final ApplicationMessageStream messageStream) {

        this.applicationContentRoot = contentRoot;

        setId("root");

        final Div messageStreamBtnWrapper = new Div();
        messageStreamBtnWrapper.addClickListener(event -> messageStream.open());
        messageStreamBtnWrapper.addClassName("wrapper");
        messageStreamBtnWrapper.add(new CircleButton(VaadinIcon.CHAT.create()));

        add(header, contentRoot, messageStreamBtnWrapper);
    }

    @Override
    public void showRouterLayoutContent(final HasElement content) {
        applicationContentRoot.showView(content);
    }

}
