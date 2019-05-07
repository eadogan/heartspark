package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
@HtmlImport("styles/hs-dialog-styles.html")
public class ApplicationPopupSidebar extends Dialog {

    public ApplicationPopupSidebar() {
        getElement().setAttribute("theme", "popup");
    }

}
