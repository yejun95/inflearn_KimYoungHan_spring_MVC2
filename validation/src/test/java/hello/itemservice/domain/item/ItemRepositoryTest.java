package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clear();
    }

    @Test
    void save() {
        //given
        Item item = new Item("item1", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(savedItem).isEqualTo(findItem);
    }

    @Test
    void findByAll() {
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        Item savedItem1 = itemRepository.save(item1);
        Item savedItem2 = itemRepository.save(item2);

        //when
        List<Item> allItem = itemRepository.findAll();

        //then
        assertThat(allItem.size()).isEqualTo(2);
        assertThat(allItem).contains(savedItem1, savedItem2);
    }

    @Test
    void update() {
        //given
        Item item = new Item("item1", 10000, 10);

        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updateItem = new Item("item2", 20000, 20);
        itemRepository.update(itemId, updateItem);

        //then
        Item byId = itemRepository.findById(savedItem.getId());

        assertThat(byId.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(byId.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(byId.getQuantity()).isEqualTo(updateItem.getQuantity());
    }
}