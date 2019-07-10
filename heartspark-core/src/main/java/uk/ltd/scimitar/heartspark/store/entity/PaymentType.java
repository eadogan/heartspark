package uk.ltd.scimitar.heartspark.store.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "payment_type")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentType implements Serializable {

    @Id
    @Column(name = "type")
    private String type;
    @Column(name = "enabled")
    private Boolean enabled;

}
