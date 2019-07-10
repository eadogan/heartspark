package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "currency_type")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyType implements Serializable {

    @Id
    @Column(name = "code")
    private String code;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_type", referencedColumnName = "type")
    private PaymentType paymentType;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "name")
    private String name;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "lowest_denom_ratio")
    private Integer lowestDenominationRatio;

}
