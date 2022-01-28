package com.example.order.dao;

import com.example.order.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item getFirstByNameEqualsAndQuantityIsNotNull(String name);
}
