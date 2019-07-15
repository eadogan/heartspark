package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.repository.GenderConverter;
import uk.ltd.scimitar.heartspark.profile.repository.MatchedGenderConverter;
import uk.ltd.scimitar.heartspark.profile.repository.TriStateTypeConverter;
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
    @Column(name = "profile_name", length = 40)
    private String profileName;
    @Column(name = "profile_message")
    private String profileMessage;
    @Column(name = "tag_line")
    private String tagLine;
    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    @Column(name = "eye_colour")
    @Enumerated(EnumType.STRING)
    private EyeColour eyeColour;
    @Column(name = "hair_colour")
    @Enumerated(EnumType.STRING)
    private HairColour hairColour;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "height")
    private Integer height;
    @Column(name = "ethnicity")
    @Enumerated(EnumType.STRING)
    private Ethnicity ethnicity;
    @Column(name = "religion")
    @Enumerated(EnumType.STRING)
    private Religion religion;
    @Column(name = "education")
    @Enumerated(EnumType.STRING)
    private Education education;
    @Column(name = "salary")
    @Enumerated(EnumType.STRING)
    private Salary salary;
    @Column(name = "smoker")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType smoker;
    @Column(name = "driving_licence")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType drivingLicence;
    @Column(name = "alcohol_drinker")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType alcoholDrinker;
    @Column(name = "children")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType children;
    @Column(name = "young_children")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType youngChildren;
    @Column(name = "employed")
    @Convert(converter = TriStateTypeConverter.class)
    private TriStateType employed;

    @Builder
    public Profile(long id,
                   Account account,
                   Set<Tag> tags,
                   Gender gender,
                   MatchedGender matchedGender,
                   LocalDate dateOfBirth,
                   String profileName,
                   String profileMessage,
                   String tagLine,
                   BodyType bodyType,
                   EyeColour eyeColour,
                   HairColour hairColour,
                   Integer weight,
                   Integer height,
                   Ethnicity ethnicity,
                   Religion religion,
                   Education education,
                   Salary salary,
                   TriStateType smoker,
                   TriStateType drivingLicence,
                   TriStateType alcoholDrinker,
                   TriStateType children,
                   TriStateType youngChildren,
                   TriStateType employed,
                   Date createdAt,
                   Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.account = account;
        this.tags = tags;
        this.gender = gender;
        this.matchedGender = matchedGender;
        this.dateOfBirth = dateOfBirth;
        this.profileName = profileName;
        this.profileMessage = profileMessage;
        this.tagLine = tagLine;
        this.bodyType = bodyType;
        this.eyeColour = eyeColour;
        this.hairColour = hairColour;
        this.weight = weight;
        this.height = height;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.education = education;
        this.salary = salary;
        this.smoker = smoker;
        this.drivingLicence = drivingLicence;
        this.alcoholDrinker = alcoholDrinker;
        this.children = children;
        this.youngChildren = youngChildren;
        this.employed = employed;
    }

//    private String profileImageSrc;
//    private Collection<ProfileMedia> profileMedia;

}
