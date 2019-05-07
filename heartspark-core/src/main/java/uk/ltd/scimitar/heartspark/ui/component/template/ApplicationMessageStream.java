package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ltd.scimitar.heartspark.ui.component.element.HeaderBar;

@SpringComponent
@UIScope
@HtmlImport("styles/hs-dialog-styles.html")
public class ApplicationMessageStream extends Dialog {

    @Autowired
    public ApplicationMessageStream() {
        getElement().setAttribute("theme", "message-stream");

        final HeaderBar headerBar = new HeaderBar();
        headerBar.onCloseAction(event -> close());

        add(headerBar);
    }

}
