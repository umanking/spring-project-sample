package io.github.umanking.domain.bucket;

import io.github.umanking.domain.BaseEntity;
import io.github.umanking.domain.item.Item;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 장바구니 엔티티
 *
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Entity
@Data
public class Bucket extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Item item;

    private BigDecimal totalPrice;

    // todo: 장바구니에 상품 추가하기
    // todo: 장바구니에서 상품 빼기
    // todo: 장바구니 목록 조회


}
