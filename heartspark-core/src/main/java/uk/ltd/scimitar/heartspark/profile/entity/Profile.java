package uk.ltd.scimitar.heartspark.profile.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.account.entity.Account;
import uk.ltd.scimitar.heartspark.common.db.Auditable;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
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

    @Builder
    public Profile(long id,
                   Account account,
                   Date createdAt,
                   Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.account = account;
    }

}
