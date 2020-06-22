package io.github.umanking.domain.order;

import io.github.umanking.domain.BaseEntity;
import io.github.umanking.domain.item.Item;
import io.github.umanking.domain.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Entity
@Data
public class OrderItem extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Item item;

    private BigDecimal orderPrice;
    private int count;


}
