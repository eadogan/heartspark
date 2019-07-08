package uk.ltd.scimitar.heartspark.account.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;
import uk.ltd.scimitar.heartspark.util.db.LocaleConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "account_role_map",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email_address", referencedColumnName = "email_address")
    private Credential credential;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "terms_conditions_accept")
    private Boolean acceptedTermsAndConditions;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "country")
    @Convert(converter = LocaleConverter.class)
    private Locale country;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    @Builder
    public Account(long id,
                   Set<Role> roles,
                   Credential credential,
                   String firstName,
                   Boolean acceptedTermsAndConditions,
                   String postalCode,
                   Locale country,
                   Profile profile,
                   Date createdAt,
                   Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.roles = roles;
        this.credential = credential;
        this.firstName = firstName;
        this.acceptedTermsAndConditions = acceptedTermsAndConditions;
        this.postalCode = postalCode;
        this.country = country;
        this.profile = profile;
    }

}
