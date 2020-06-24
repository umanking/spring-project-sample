package io.github.umanking.domain.order;

import io.github.umanking.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * @author Geonguk Han
 * @since 2020-06-22
 */
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Test
    void processOrder() {
        // givne
        final Item macbookPro = new Item();
        macbookPro.setId(1L);
        macbookPro.setName("맥북 프로");
        macbookPro.setPrice(BigDecimal.valueOf(2200000));
        macbookPro.setStockQuantity(100);

        final Item cookedRice = new Item();
        cookedRice.setId(2L);
        cookedRice.setName("햇반");
        cookedRice.setPrice(BigDecimal.valueOf(30000));
        cookedRice.setStockQuantity(1000);

        final OrderItem orderItem = new OrderItem();
        orderItem.setId(1L);
        orderItem.setItem(macbookPro);
        orderItem.setCount(1);
        orderItem.setOrderPrice(macbookPro.getPrice().multiply(BigDecimal.valueOf(orderItem.getCount())));

        final OrderItem orderItem1 = new OrderItem();
        orderItem1.setId(2L);
        orderItem1.setItem(cookedRice);
        orderItem1.setCount(2);
        orderItem1.setOrderPrice(cookedRice.getPrice().multiply(BigDecimal.valueOf(orderItem1.getCount())));

        final Order order = new Order();
        order.setId(1L);
        order.addOrderItem(orderItem);
        order.addOrderItem(orderItem1);
        order.setOrderStatus(OrderStatus.ORDER_COMPLETE);


        given(orderRepository.save(any())).willReturn(order);

        // when
        final Order actual = orderService.processOrder(any());

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getOrderStatus()).isEqualTo(order.getOrderStatus());
        assertThat(actual.getOrderItems().size()).isEqualTo(2);
    }
}