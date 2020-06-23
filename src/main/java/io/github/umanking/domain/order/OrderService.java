package io.github.umanking.domain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-06-22
 */
@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order processOrder(Order order) {
        final List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            final BigDecimal totalPrice = orderItem.getOrderPrice().multiply(BigDecimal.valueOf(orderItem.getCount()));
            if (totalPrice.intValue() <= BigDecimal.ZERO.intValue()) {
                throw new RuntimeException("금액이 잘 못 계산되었습니다.");
            }
        }
        return orderRepository.save(order);
    }
}
