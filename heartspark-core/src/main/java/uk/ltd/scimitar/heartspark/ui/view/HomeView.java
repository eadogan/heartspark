package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import uk.ltd.scimitar.heartspark.ui.HeartSparkUI;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "", layout = HeartSparkUI.class)
@HtmlImport("styles/view-home-styles.html")
@PageTitle("HeartSpark.singles")
public class HomeView extends Div {

    public HomeView() {
        setId("home-view");
        add(new Label("Home View"));
    }


}
