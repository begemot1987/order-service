package com.example.order.service;

import com.example.order.model.Order;
import java.util.List;

public interface OrderService {
    Order add(Order order);

    List<Order> getAll();
}
