package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.repository.GenderConverter;
import uk.ltd.scimitar.heartspark.profile.repository.MatchedGenderConverter;
import uk.ltd.scimitar.heartspark.tag.entity.Tag;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = { "account", "tags" })
@Data
@Entity
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor
public class Profile extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(mappedBy = "profile")
    private Account account;
    @OneToMany(mappedBy="profile")
    private Set<Tag> tags;
    @Column(name = "gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    @Column(name = "matched_gender")
    @Convert(converter = MatchedGenderConverter.class)
    private MatchedGender matchedGender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Builder
    public Profile(long id,
                   Account account,
                   Set<Tag> tags,
                   Gender gender,
                   MatchedGender matchedGender,
                   LocalDate dateOfBirth,
                   Date createdAt,
                   Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.account = account;
        this.tags = tags;
        this.gender = gender;
        this.matchedGender = matchedGender;
        this.dateOfBirth = dateOfBirth;
    }

}
