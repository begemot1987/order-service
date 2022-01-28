package com.example.order.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.example.order.dao.OrderRepository;
import com.example.order.model.Item;
import com.example.order.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository orderRepository;
    private Order firstOrder;
    private Order secondOrder;

    @BeforeEach
    public void init() {
        Item apple = new Item();
        apple.setId(1L);
        apple.setName("apple");
        apple.setPrice(2.5);
        apple.setQuantity(100L);
        firstOrder = new Order();
        firstOrder.setOrderTime(LocalDateTime.now());
        firstOrder.setItem(apple);
        firstOrder.setQuantity(10L);
        firstOrder.setPrice(25.0);
        secondOrder = new Order();
        secondOrder.setOrderTime(LocalDateTime.now());
        secondOrder.setItem(apple);
        secondOrder.setQuantity(20L);
        secondOrder.setPrice(50.0);
    }

    @Test
    void add() {
        firstOrder.setId(1L);
        Mockito.when(orderRepository.save(firstOrder)).thenReturn(firstOrder);
        Order actual = orderService.add(firstOrder);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(firstOrder, actual);
    }

    @Test
    void getAll() {
        firstOrder.setId(1L);
        secondOrder.setId(2L);
        Mockito.when(orderRepository.findAll()).thenReturn(List.of(firstOrder, secondOrder));
        List<Order> actual = orderService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(firstOrder, secondOrder), actual);
    }
}