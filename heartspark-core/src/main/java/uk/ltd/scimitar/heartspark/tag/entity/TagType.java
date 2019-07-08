package uk.ltd.scimitar.heartspark.tag.entity;

public enum TagType {

    MESSAGING(true, false),
    BLOCKED(true, false),
    LIKE(true, false),
    MATCHED(true, true),
    VIEW_PROFILE(false, false),
    VIEW_GALLERY(false, false),
    CUSTOM(true, false);

    private final boolean showOnUi;
    private final boolean strong;

    TagType(boolean showOnUi, final boolean strong) {
        this.showOnUi = showOnUi;
        this.strong = strong;
    }

    public boolean isShowOnUi() {
        return showOnUi;
    }

    public boolean isStrong() {
        return strong;
    }

    public static TagType fromString(final String tagName) {
        if (tagName == null || tagName.trim().isEmpty())
            return TagType.CUSTOM;
        for (TagType tagType : values()) {
            if (tagName.trim().toUpperCase().equals(tagType.name())) {
                return tagType;
            }
        }
        return TagType.CUSTOM;
    }

}
