package io.github.umanking.domain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        return orderRepository.save(order);
    }
}
