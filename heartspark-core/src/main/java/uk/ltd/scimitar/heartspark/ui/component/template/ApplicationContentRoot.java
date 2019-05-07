package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HtmlContainer;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@HtmlImport("styles/app-content-root-styles.html")
public class ApplicationContentRoot extends FlexLayout {

    private final Div content = new Div();

    @Autowired
    public ApplicationContentRoot(final ApplicationSidebar sidebar) {
        setId("content-root");
        content.setId("content");
        add(sidebar, content);
    }

    public void showView(final HasElement view) {
        content.removeAll();
        content.getElement().appendChild(view.getElement());
    }

}
