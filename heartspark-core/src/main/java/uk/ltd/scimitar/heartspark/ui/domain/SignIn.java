package uk.ltd.scimitar.heartspark.ui.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SignIn implements Serializable {

    private String emailAddress;
    private String password;

}
