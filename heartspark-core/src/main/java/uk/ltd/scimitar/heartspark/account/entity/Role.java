package uk.ltd.scimitar.heartspark.account.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    @Id
    @Column(name = "name", length = 15)
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
