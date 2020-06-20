package io.github.umanking.service;

import io.github.umanking.domain.item.Item;
import io.github.umanking.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Service
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<Item> findItems(final Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    public Item getItem(final Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new RuntimeException("item is not eixst : " + id)
        );

    }
}
