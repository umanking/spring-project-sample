package io.github.umanking.service;

import io.github.umanking.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
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
}
