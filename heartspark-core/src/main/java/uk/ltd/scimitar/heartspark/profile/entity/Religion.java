package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public enum Religion implements Serializable {

    UNSPECIFIED("unspecified"),
    ATHEIST("atheist"),
    CHRISTIAN("christian"),
    HINDU("hindu"),
    MUSLIM("muslim"),
    BUDDHIST("buddhist"),
    OTHER("other");

    @Getter
    private final String label;

}
