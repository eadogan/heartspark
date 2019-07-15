package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum BodyType implements Serializable {

    UNSPECIFIED("unspecified"),
    ATHLETIC("body_type.athletic"),
    SLIM("body_type.slim"),
    MUSCULAR("body_type.muscular"),
    STOCKY("body_type.stocky"),
    AVERAGE("body_type.average"),
    AVERAGE_FIT("body_type.average_fit"),
    CURVACEOUS("body_type.curvaceous"),
    CUDDLY("body_type.cuddly"),
    PLUS_SIZED("body_type.plus_sized");

    @Getter
    private final String label;

//    @Override
//    public String getKey() {
//        return this.name();
//    }
//
//    @Override
//    public boolean isUnspecified() {
//        return this.equals(UNSPECIFIED);
//    }

}
