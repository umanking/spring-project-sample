package io.github.umanking.repository;

import io.github.umanking.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
