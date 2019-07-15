package uk.ltd.scimitar.heartspark.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "credential")
@NoArgsConstructor
@AllArgsConstructor
public class Credential implements Serializable {

    @Id
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "password", length = 60)
    private String password;
    @OneToOne(mappedBy = "credential")
    private Account account;

}
