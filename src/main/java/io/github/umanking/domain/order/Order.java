package io.github.umanking.domain.order;

import io.github.umanking.domain.BaseEntity;
import io.github.umanking.domain.user.User;
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
public class Order extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private User user;

    private OrderItem orderItem;

    private OrderStatus orderStatus;


}
