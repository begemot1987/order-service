package com.example.order.dao;

import com.example.order.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderTimeLessThanEqual(LocalDateTime expiredTime);
}
