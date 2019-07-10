package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.util.db.UUIDConverter;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true, exclude = { "storeItem", "currencyType" })
@Data
@Entity
@Table(name = "store_item_price")
@NoArgsConstructor
@AllArgsConstructor
public class StoreItemPrice extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_item_id", nullable = false)
    private StoreItem storeItem;
    @Column(name = "sku")
    @Convert(converter = UUIDConverter.class)
    private UUID sku;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", nullable = false)
    private CurrencyType currencyType;
    @Column(name = "value")
    private Integer value;
    @Column(name = "tokens")
    private Integer tokens;

}
