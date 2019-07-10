package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.ltd.scimitar.heartspark.common.db.Auditable;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true, exclude = { "storeItemCategory", "tokenModifier" })
@Data
@Entity
@Table(name = "store_item")
@NoArgsConstructor
@AllArgsConstructor
public class StoreItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_item_category_id", nullable = false)
    private StoreItemCategory storeItemCategory;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name", length = 40)
    private String name;
    @Column(name = "short_description")
    private String shortDescription;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "token_modifier", nullable = false)
    private TokenModifier tokenModifier;

}
