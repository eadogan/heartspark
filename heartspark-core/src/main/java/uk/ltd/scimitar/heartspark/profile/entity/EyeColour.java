package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum EyeColour implements Serializable {

    UNSPECIFIED("unspecified"),
    BROWN("colour.brown"),
    HAZEL("colour.hazel"),
    BLUE("colour.blue"),
    GREEN("colour.green"),
    SILVER("colour.silver"),
    AMBER("colour.amber"),
    MIXED("colour.mixed");

    @Getter
    private String label;

}
