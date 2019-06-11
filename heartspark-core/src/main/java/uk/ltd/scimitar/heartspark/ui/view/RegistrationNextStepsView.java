package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import uk.ltd.scimitar.heartspark.ui.component.template.WebsiteTemplate;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Route(value = "next-steps", layout = WebsiteTemplate.class)
@PageTitle("HeartSpark.singles")
public class RegistrationNextStepsView extends Div {
}
