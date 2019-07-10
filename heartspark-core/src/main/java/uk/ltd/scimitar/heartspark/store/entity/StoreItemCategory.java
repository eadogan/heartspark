package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.ltd.scimitar.heartspark.common.db.Auditable;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true, exclude = { "store", "parentCategory" })
@Data
@Entity
@Table(name = "store_item_category")
@NoArgsConstructor
@AllArgsConstructor
public class StoreItemCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private StoreItemCategory parentCategory;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "display_text")
    private String displayText;

}
