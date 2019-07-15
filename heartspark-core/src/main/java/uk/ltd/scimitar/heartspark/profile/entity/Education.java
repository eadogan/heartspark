package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum Education implements Serializable {

    UNSPECIFIED("unspecified"),
    SECONDARY("secondary"),
    COLLEGE("college"),
    OPEN_UNIVERSITY("open_university"),
    UNIVERSITY("university");

    @Getter
    private final String label;

}
