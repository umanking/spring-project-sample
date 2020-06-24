package io.github.umanking.domain.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


/**
 * @author Geonguk Han
 * @since 2020-06-24
 */
class OrderItemTest {

    @Test
    void shouldValidateTotalPrice() {
        // given
        final OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(BigDecimal.valueOf(10000));
        orderItem.setCount(3);

        // when
        orderItem.validatePrice();
    }

    @Test
    void shouldNotValidateTotalPrice_WhenOrderPriceZero() {
        /*final OrderItem orderItem = Mockito.mock(OrderItem.class);
        lenient().doNothing().when(orderItem).validatePrice();*/

        // given
        final OrderItem orderItem = new OrderItem();
        orderItem.setOrderPrice(BigDecimal.valueOf(0));

        // when, then
        Assertions.assertThrows(RuntimeException.class, () ->{
            orderItem.validatePrice();
        });
    }
}