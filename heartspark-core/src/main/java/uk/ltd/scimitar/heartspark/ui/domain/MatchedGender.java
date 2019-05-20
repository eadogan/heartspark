package uk.ltd.scimitar.heartspark.ui.domain;

public enum MatchedGender {

    MALE("Man", "Men"), FEMALE("Woman", "Women"), EITHER("Man or Woman", "Men or Women");

    private String noun;
    private String plural;

    MatchedGender(final String noun, final String plural) {
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
