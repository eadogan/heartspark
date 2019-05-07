package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@HtmlImport("styles/app-message-stream-styles.html")
public class ApplicationMessageStream extends Dialog {

    @Autowired
    public ApplicationMessageStream() {
        setId("message-stream-root");
        add(new Label("Message Stream"));
    }

}
