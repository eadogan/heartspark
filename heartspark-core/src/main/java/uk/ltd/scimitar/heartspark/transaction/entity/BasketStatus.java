package uk.ltd.scimitar.heartspark.transaction.entity;

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
@Table(name = "basket_status")
@NoArgsConstructor
@AllArgsConstructor
public class BasketStatus implements Serializable {

    @Id
    @Column(name = "status")
    private String status;

}
