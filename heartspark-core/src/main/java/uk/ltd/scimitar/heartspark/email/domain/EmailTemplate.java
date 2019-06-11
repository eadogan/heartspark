package uk.ltd.scimitar.heartspark.email.domain;

public enum EmailTemplate {

    FORGOT_PASSWORD("forgot-password"),
    WELCOME("welcome");

    private String templateName;

    EmailTemplate(final String templateName) {
        this.templateName = templateName;
    }

    public String templateName() {
        return templateName;
    }

}
