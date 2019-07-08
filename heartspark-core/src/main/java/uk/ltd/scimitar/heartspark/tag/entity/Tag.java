package uk.ltd.scimitar.heartspark.tag.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
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

    @Builder
    public Tag(long id,
               Profile profile,
               String name,
               Boolean enabled,
               Date createdAt,
               Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.enabled = enabled;
    }

}
