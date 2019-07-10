package uk.ltd.scimitar.heartspark.transaction.entity;

import lombok.*;
import uk.ltd.scimitar.heartspark.common.db.Auditable;
import uk.ltd.scimitar.heartspark.store.entity.StoreItemPrice;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "basket_item")
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id", referencedColumnName = "id", nullable = false)
    private Basket basket;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_item_price_id", referencedColumnName = "id", nullable = false)
    private StoreItemPrice storeItemPrice;

}
