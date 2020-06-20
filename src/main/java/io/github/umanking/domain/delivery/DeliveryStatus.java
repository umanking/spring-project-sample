package io.github.umanking.domain.delivery;

import lombok.Getter;

/**
 * Delivery Status
 *
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Getter
public enum DeliveryStatus {

    // todo: move to delivery status
    SHIPPING_READY("상품준비중"),
    SHIPPING_START("배송시작"),
    SHIPPING_PROGRESS("배송중"),
    SHIPPING_COMPLETE("배송완료");

    private final String description;

    DeliveryStatus(final String description) {
        this.description = description;
    }
}
