package io.github.umanking.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-06-22
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
