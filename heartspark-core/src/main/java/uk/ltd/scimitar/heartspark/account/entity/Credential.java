package uk.ltd.scimitar.heartspark.account.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "credential")
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    @Id
    @Column(name = "email_address")
    private String emailAddress;
    private String password;
    @OneToOne(mappedBy = "credential")
    private Account account;

}
