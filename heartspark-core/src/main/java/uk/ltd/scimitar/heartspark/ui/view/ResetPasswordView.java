package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import uk.ltd.scimitar.heartspark.ui.component.template.WebsiteTemplate;

import javax.annotation.PostConstruct;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PageTitle("HeartSpark.singles")
@Route(value = "reset-password", layout = WebsiteTemplate.class)
public class ResetPasswordView extends Div {

    @PostConstruct
    void initUi() {
        setClassName("card");
    }

}
