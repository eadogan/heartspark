package uk.ltd.scimitar.heartspark.ui.component.element;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;

@HtmlImport("styles/element-circle-button-styles.html")
public class CircleButton extends Label {

    public CircleButton(final Icon icon) {
        addClassName("circle");
        add(icon);
    }

}
