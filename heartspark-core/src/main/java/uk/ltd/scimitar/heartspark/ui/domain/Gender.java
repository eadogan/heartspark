package uk.ltd.scimitar.heartspark.ui.domain;

public enum Gender {

    MALE("Man", "Men"), FEMALE("Woman", "Women");

    private String noun;
    private String plural;

    Gender(final String noun, final String plural) {
        this.noun = noun;
        this.plural = plural;
    }

    public String noun() {
        return noun;
    }

    public String plural() {
        return plural;
    }

}
