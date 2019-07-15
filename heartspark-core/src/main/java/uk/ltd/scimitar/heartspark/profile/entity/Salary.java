package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum Salary implements Serializable {

    UNSPECIFIED("unspecified"),
    LESS_THAN_10_K("less_than_10K"),
    OVER_10K("over_10K"),
    OVER_20K("over_20K"),
    OVER_30K("over_30K"),
    OVER_50K("over_50K"),
    OVER_75K("over_75K"),
    OVER_100K("over_100K"),
    OVER_150K("over_150K");

    @Getter
    private final String label;

}
