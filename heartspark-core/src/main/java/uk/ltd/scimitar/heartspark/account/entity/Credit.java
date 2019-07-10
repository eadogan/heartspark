package uk.ltd.scimitar.heartspark.account.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.common.db.Auditable;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true, exclude = { "account" })
@Data
@Entity
@Table(name = "account_credit")
@NoArgsConstructor
@AllArgsConstructor
public class Credit extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tokens")
    private Integer tokens;
    @OneToOne(mappedBy = "credit")
    private Account account;

    @Builder
    public Credit(long id,
                  Integer tokens,
                  Account account,
                  Date createdAt,
                  Date updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.tokens = tokens;
        this.account = account;
    }


}
