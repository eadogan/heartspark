package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum Ethnicity implements Serializable {

    UNSPECIFIED("unspecified"),
    AFRICAN("ethnic.african"),
    ASIAN("ethnic.asian"),
    CAUCASIAN("ethnic.caucasian"),
    HISPANIC("ethnic.hispanic"),
    INDIAN("ethnic.indian");

    @Getter
    private final String label;

}
