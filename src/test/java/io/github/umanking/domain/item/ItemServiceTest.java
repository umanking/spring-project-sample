package io.github.umanking.domain.item;

import io.github.umanking.domain.item.Item;
import io.github.umanking.domain.item.ItemRepository;
import io.github.umanking.domain.item.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @Mock
    ItemRepository itemRepository;

    @Mock
    Pageable pageable;

    @Test
    @DisplayName("item paging 조회")
    void findItems() {
        final List<Item> items = Arrays.asList(
                new Item("Macbook pro", BigDecimal.valueOf(2200000), 200),
                new Item("Iphone", BigDecimal.valueOf(1200000), 300));

        // given
        final Page<Item> t = new PageImpl<>(items);
        given(itemRepository.findAll(pageable)).willReturn(t);

        // when
        final Page<Item> actual = itemService.findItems(pageable);

        // then
        assertThat(actual.getTotalElements()).isEqualTo(items.size());

        // 동일한 값객체로 인식하나?
        assertThat(actual.get().collect(Collectors.toList()).get(0)).isEqualTo(items.get(0));
        assertThat(actual.get().collect(Collectors.toList())).containsExactlyInAnyOrder(items.get(0), items.get(1));
    }

    @Test
    void getItem() {
        // given
        final Item macbookPro = new Item("Macbook pro", BigDecimal.valueOf(2200000), 200);
        given(itemRepository.findById(anyLong())).willReturn(Optional.of(macbookPro));

        // when
        final Item actual = itemService.getItem(anyLong());

        // then
        assertThat(actual.getName()).isEqualTo(macbookPro.getName());
        assertThat(actual.getName()).isEqualTo(macbookPro.getName());
        assertThat(actual.getPrice()).isEqualTo(macbookPro.getPrice());
        assertThat(actual.getStockQuantity()).isEqualTo(macbookPro.getStockQuantity());
    }
}