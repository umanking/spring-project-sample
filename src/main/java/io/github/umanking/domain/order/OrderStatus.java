package io.github.umanking.domain.order;

import lombok.Getter;

/**
 * Order Status
 *
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Getter
public enum OrderStatus {

    //'ORDER_COMPLETE',
    // 'PRODUCT_PROGRESS',
    // 'SHIPPING_READY',
    // 'SHIPPING_PROGRESS',
    // 'SHIPPING_COMPLETE',
    // 'SHIPPING_CANCEL',
    // 'SHIPPING_RETURN',
    // 'NO_SHIPPING'

    ORDER_COMPLETE("주문완료"),
    ORDER_CANCEL("주문취소"),
    ORDER_REFUND("주문환불");

    private final String description;

    OrderStatus(final String description) {
        this.description = description;
    }


}
