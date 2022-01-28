package com.example.order.service.impl;

import java.util.List;
import com.example.order.dao.ItemRepository;
import com.example.order.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
    @InjectMocks
    private ItemServiceImpl productService;
    @Mock
    private ItemRepository itemRepository;
    private Item apple;
    private Item banana;

    @BeforeEach
    public void init() {
        apple = new Item();
        apple.setName("apple");
        apple.setPrice(2.5);
        apple.setQuantity(100L);
        banana = new Item();
        banana.setName("banana");
        banana.setPrice(5.5);
        banana.setQuantity(150L);
    }

    @Test
    void getById_Ok() {
        apple.setId(1L);
        Mockito.when(itemRepository.getById(1L)).thenReturn(apple);
        Item actual = productService.getById(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(apple, actual);
    }

    @Test
    void getAll_OK() {
        apple.setId(1L);
        banana.setId(2L);
        Mockito.when(itemRepository.findAll()).thenReturn(List.of(apple, banana));
        List<Item> actual = productService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(apple, banana), actual);
    }

    @Test
    void getCheapestByItemWithEqualQuantity_Ok() {
        Mockito.when(itemRepository.getFirstByNameEqualsAndQuantityIsNotNull("apple")).thenReturn(apple);
        Item actual = productService.getCheapestByItem("apple", 100L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals("apple", actual.getName());
        Assertions.assertEquals(100L, actual.getQuantity());
        Assertions.assertEquals(2.5, actual.getPrice());
        Assertions.assertNotNull(apple);
        Assertions.assertEquals(0, apple.getQuantity());
    }

    @Test
    void getCheapestByItemWithGreaterQuantity_Ok() {
        Mockito.when(itemRepository.getFirstByNameEqualsAndQuantityIsNotNull("apple")).thenReturn(apple);
        Item actual = productService.getCheapestByItem("apple", 101L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals("apple", actual.getName());
        Assertions.assertEquals(100L, actual.getQuantity());
        Assertions.assertEquals(2.5, actual.getPrice());
        Assertions.assertNotNull(apple);
        Assertions.assertEquals(0, apple.getQuantity());
    }
}