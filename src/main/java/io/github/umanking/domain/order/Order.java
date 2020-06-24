package io.github.umanking.domain.order;

import io.github.umanking.domain.BaseEntity;
import io.github.umanking.domain.user.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private BigDecimal totalOrderPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDER_COMPLETE;

    private LocalDateTime orderDate = LocalDateTime.now();

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public BigDecimal getTotalOrderPrice() {
        orderItems.forEach(orderItem -> totalOrderPrice.add(orderItem.getMultiply()));
        return totalOrderPrice;
    }
}
