package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.ltd.scimitar.heartspark.common.db.Auditable;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
public class Store extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 30)
    private String name;

}
