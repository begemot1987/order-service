package com.example.order.service.impl;

import com.example.order.dao.ItemRepository;
import com.example.order.model.Item;
import com.example.order.service.ItemService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.getById(id);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item getCheapestByItem(String item, Long quantity) {
        Item product = itemRepository.getFirstByNameEqualsAndQuantityIsNotNull(item);
        Item response = new Item();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        Long responseQuantity
                = product.getQuantity() >= quantity ? quantity : product.getQuantity();
        response.setQuantity(responseQuantity);
        product.setQuantity(product.getQuantity() - responseQuantity);
        itemRepository.save(product);
        return response;
    }
}
