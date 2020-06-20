package io.github.umanking.domain.item;

import io.github.umanking.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Entity
@Data
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "name is not empty")
    private String name;

    @NotNull(message = "price is not null")
    private BigDecimal price;

    private int stockQuantity;


}
