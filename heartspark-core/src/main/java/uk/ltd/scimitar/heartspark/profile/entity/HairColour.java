package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum HairColour implements Serializable {

    UNSPECIFIED("unspecified"),
    BLACK("colour.black"),
    BROWN("colour.brown"),
    BLOND("colour.blond"),
    AUBURN("colour.auburn"),
    CHESTNUT("colour.chestnut"),
    GINGER("colour.ginger"),
    GRAY("colour.gray"),
    WHITE("colour.white"),
    BALD("colour.bald"),
    COLOURED("colour.coloured"),
    STREAKED("colour.streaked"),
    DYED("colour.dyed");

    @Getter
    private final String label;

}
