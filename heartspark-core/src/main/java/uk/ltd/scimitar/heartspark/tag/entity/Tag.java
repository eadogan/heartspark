package uk.ltd.scimitar.heartspark.tag.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;
import uk.ltd.scimitar.heartspark.tag.repository.TagTypeConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = { "profile", "taggedProfiles" })
@Data
@Entity
@Table(name = "tag")
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
    @Column(name = "name")
    private String name;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "tag_type")
    @Convert(converter = TagTypeConverter.class)
    private TagType tagType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tag_profile_map",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private Set<Profile> taggedProfiles;

    @Builder
    public Tag(long id,
               Profile profile,
               String name,
               Boolean enabled,
               TagType tagType,
               Set<Profile> taggedProfiles,
               Date createdAt,
               Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.enabled = enabled;
        this.tagType = tagType;
        this.taggedProfiles = taggedProfiles;
    }

}
