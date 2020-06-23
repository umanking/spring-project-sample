package io.github.umanking.domain.delivery;

import io.github.umanking.domain.BaseEntity;
import io.github.umanking.domain.order.Order;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Entity
@Data
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

//    private Order order;

}
