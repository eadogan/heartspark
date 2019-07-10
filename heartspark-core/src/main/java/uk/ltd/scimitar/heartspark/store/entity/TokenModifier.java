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
@Table(name = "token_modifier")
@NoArgsConstructor
@AllArgsConstructor
public class TokenModifier implements Serializable {

    @Id
    @Column(name = "id", unique = true, length = 30)
    private String name;

}
