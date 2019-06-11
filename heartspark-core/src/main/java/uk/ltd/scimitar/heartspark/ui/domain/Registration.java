package uk.ltd.scimitar.heartspark.ui.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;

@Data
public class Registration implements Serializable {

    private String givenName;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private Gender gender;
    private MatchedGender matchedGender;
    private LocalDate dateOfBirth;
    private String postalCode;
    private Boolean termsAndConditions;
    private Locale country;

}
