package uk.ltd.scimitar.heartspark.ui.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Emphasis;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.account.entity.Credential;
import uk.ltd.scimitar.heartspark.account.entity.Role;
import uk.ltd.scimitar.heartspark.account.service.AccountService;
import uk.ltd.scimitar.heartspark.ui.component.template.WebsiteTemplate;
import uk.ltd.scimitar.heartspark.ui.domain.Gender;
import uk.ltd.scimitar.heartspark.ui.domain.MatchedGender;
import uk.ltd.scimitar.heartspark.ui.domain.Registration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;

import static java.util.regex.Pattern.matches;

@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PageTitle("HeartSpark.singles")
@Route(value = "registration", layout = WebsiteTemplate.class)
@HtmlImport("styles/view-registration-styles.html")
public class RegistrationView extends Div {

    private static final String DEFAULT_COLUMN_WIDTH = "100%";
    private static final String UK_POSTCODE_REGEX
            = "^(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})$";

    private AccountService accountService;

    @Autowired
    public RegistrationView(final AccountService accountService) {

        this.accountService = accountService;

        setClassName("card");

        FlexLayout welcomeTextLayout = new FlexLayout();
        welcomeTextLayout.setId("welcome");

        Paragraph title = new Paragraph("Register on HeartSpark");
        title.setClassName("text-large");

        Paragraph subtitle = new Paragraph("Why not, creating an account is free");
        subtitle.setClassName("text-small");

        welcomeTextLayout.add(title, subtitle);

        add(welcomeTextLayout);

        final Registration registration = new Registration();
        registration.setCountry(Locale.UK);

        final Binder<Registration> registrationBinder = new Binder<>();

        final FormLayout registrationLayout = new FormLayout();
        registrationLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 2));

        final TextField givenName = new TextField();
        givenName.setWidth(DEFAULT_COLUMN_WIDTH);
        givenName.setRequired(true);
        givenName.setRequiredIndicatorVisible(true);
        givenName.setPlaceholder("First name");
        givenName.getElement().setAttribute("colspan", "2");
        registrationBinder.forField(givenName).asRequired("This is a required field")
                .bind(Registration::getGivenName, Registration::setGivenName);

        registrationLayout.add(givenName);

        final Emphasis givenNameLabel = new Emphasis("This will also show up on your profile as your display name but you can change it");
        givenNameLabel.getElement().setAttribute("colspan", "2");

        registrationLayout.add(givenNameLabel);

        final TextField emailAddress = new TextField();
        emailAddress.setWidth(DEFAULT_COLUMN_WIDTH);
        emailAddress.setRequired(true);
        emailAddress.setPlaceholder("Email address");
        emailAddress.setRequiredIndicatorVisible(true);
        emailAddress.setPrefixComponent(VaadinIcon.MAILBOX.create());
        emailAddress.getElement().setAttribute("colspan", "2");
        registrationBinder.forField(emailAddress).asRequired("This is a required field")
                .bind(Registration::getEmailAddress, Registration::setEmailAddress);

        registrationLayout.add(emailAddress);

        final Emphasis emailAddressLabel = new Emphasis("This is your user name and will never show up on your profile");
        emailAddressLabel.getElement().setAttribute("colspan", "2");
        registrationLayout.add(emailAddressLabel);

        final ComboBox<Gender> gender = new ComboBox<>();
        gender.setAllowCustomValue(false);
        gender.setItemLabelGenerator(Gender::noun);
        gender.setWidth(DEFAULT_COLUMN_WIDTH);
        gender.setPlaceholder("Gender");
        gender.setItems(Gender.MALE, Gender.FEMALE);
        registrationBinder.forField(gender).asRequired("This is a required field")
                .bind(Registration::getGender, Registration::setGender);

        registrationLayout.add(gender);

        final ComboBox<MatchedGender> lookingFor = new ComboBox<>();
        lookingFor.setAllowCustomValue(false);
        lookingFor.setWidth(DEFAULT_COLUMN_WIDTH);
        lookingFor.setPlaceholder("Looking for");
        lookingFor.setItems(MatchedGender.FEMALE, MatchedGender.MALE, MatchedGender.EITHER);
        lookingFor.setItemLabelGenerator(MatchedGender::plural);
        registrationBinder.forField(lookingFor).asRequired("This is a required field")
                .bind(Registration::getMatchedGender, Registration::setMatchedGender);

        registrationLayout.add(lookingFor);

        final DatePicker dateOfBirth = new DatePicker();
        dateOfBirth.setMax(LocalDate.now().minus(18L, ChronoUnit.YEARS));
        dateOfBirth.setMin(LocalDate.now().minus(100L, ChronoUnit.YEARS));
        dateOfBirth.getElement().setAttribute("colspan", "2");
        registrationBinder.forField(dateOfBirth).asRequired("This is a required field")
                .bind(Registration::getDateOfBirth, Registration::setDateOfBirth);

        registrationLayout.add(dateOfBirth);

        final Emphasis dateOfBirthLabel = new Emphasis("You need to be at least 18 years old to register on HeartSpark.");
        dateOfBirthLabel.getElement().setAttribute("colspan", "2");
        registrationLayout.add(dateOfBirthLabel);

        final TextField postalCode = new TextField();
        postalCode.setPlaceholder("Postal code");
        postalCode.getElement().setAttribute("colspan", "2");
        registrationBinder.forField(postalCode)
                .withValidator(pc -> matches(UK_POSTCODE_REGEX, pc), "Invalid postal code format.")
                .bind(Registration::getPostalCode, Registration::setPostalCode);

        registrationLayout.add(postalCode);

        final Emphasis postalCodeLabel = new Emphasis("This will not show up anywhere on your profile, it is used to show approximate distances.");
        postalCodeLabel.getElement().setAttribute("colspan", "2");
        registrationLayout.add(postalCodeLabel);

        final Checkbox termsAndConditions = new Checkbox("By registering I confirm I am 18 year of age or older and agree with the Terms and Conditions");
        termsAndConditions.setRequiredIndicatorVisible(false);
        termsAndConditions.getElement().setAttribute("colspan", "2");
        registrationBinder.forField(termsAndConditions)
                .asRequired("This is a required field")
                .bind(Registration::getTermsAndConditions, Registration::setTermsAndConditions);

        registrationLayout.add(termsAndConditions);

        final Button registerButton = new Button("REGISTER");
        registerButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_LARGE);
        registerButton.getElement().setAttribute("colspan", "2");
        registerButton.addClickListener(e -> onRegisterClick(registrationBinder, registration));

        registrationLayout.add(registerButton);

        add(welcomeTextLayout, registrationLayout);

        registrationBinder.setBean(registration);
    }

    private void onRegisterClick(final Binder<Registration> registrationBinder,
                                 final Registration bean) {
        boolean valid = registrationBinder.writeBeanIfValid(bean);
        if (valid) {
            final String generatedPassword = "password";
            bean.setPassword(generatedPassword);

            accountService.create(new Account.Builder()
                    .withFirstName(bean.getGivenName())
                    .withLastName(bean.getFamilyName())
                    .withRoles(Set.of(new Role.Builder("USER")
                            .build()))
                    .withCredential(new Credential.Builder(bean.getEmailAddress(), bean.getPassword())
                            .build())
                    .build());
        }
    }

}
