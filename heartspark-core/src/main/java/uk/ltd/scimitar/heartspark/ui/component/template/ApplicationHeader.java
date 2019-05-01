package uk.ltd.scimitar.heartspark.ui.component.template;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class ApplicationHeader extends Div {

    public ApplicationHeader() {
        initUI();
    }

    private void initUI() {
        setHeight("60px");
    }

}
