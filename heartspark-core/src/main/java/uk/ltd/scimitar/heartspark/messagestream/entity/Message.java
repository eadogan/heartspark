package uk.ltd.scimitar.heartspark.messagestream.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.profile.entity.Profile;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "message")
@NoArgsConstructor
@AllArgsConstructor
public class Message extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_profile_id", referencedColumnName = "id")
    private Profile sourceProfile;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_profile_id", referencedColumnName = "id")
    private Profile destinationProfile;
    @Column(name = "content")
    private String content;

}
