package uk.ltd.scimitar.heartspark.ui.component.element;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;

import java.util.function.Consumer;

@HtmlImport("styles/element-header-bar-styles.html")
public class HeaderBar extends Div {

    private Consumer<ClickEvent<Button>> onCloseAction;

    public HeaderBar() {
        setClassName("header-bar");

        final Button closeBtn = new Button(VaadinIcon.CLOSE_SMALL.create());
        closeBtn.setClassName("close-btn");
        closeBtn.addClickListener(event -> onCloseAction.accept(event));

        add(closeBtn);
    }

    public void onCloseAction(final Consumer<ClickEvent<Button>> action) {
        this.onCloseAction = action;
    }

}
