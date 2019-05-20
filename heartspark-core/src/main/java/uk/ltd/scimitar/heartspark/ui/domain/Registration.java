package uk.ltd.scimitar.heartspark.ui.domain;

import java.time.LocalDate;
import java.util.Locale;

public class Registration {

    private String givenName;
    private String familyName;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private Gender gender;
    private MatchedGender matchedGender;
    private LocalDate dateOfBirth;
    private String postalCode;
    private Boolean termsAndConditions;
    private Locale country;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MatchedGender getMatchedGender() {
        return matchedGender;
    }

    public void setMatchedGender(MatchedGender matchedGender) {
        this.matchedGender = matchedGender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(Boolean termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }
}
