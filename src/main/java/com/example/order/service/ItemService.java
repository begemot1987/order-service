package com.example.order.service;

import com.example.order.model.Item;
import java.util.List;

public interface ItemService {
    Item getById(Long id);

    List<Item> getAll();

    Item getCheapestByItem(String item, Long quantity);
}
