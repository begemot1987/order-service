package com.example.order.service.impl;

import com.example.order.dao.OrderRepository;
import com.example.order.model.Order;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledOrderRemover {
    private final OrderRepository orderRepository;

    public ScheduledOrderRemover(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(cron = "0 * * * * * ", zone = "Europe/Kiev")
    public void removeExpired() {
        System.out.println("deleted");
        LocalDateTime expiredTime = LocalDateTime.now().minusMinutes(10);
        List<Order> expired = orderRepository.findAllByOrderTimeLessThanEqual(expiredTime);
        if (!expired.isEmpty()) {
            orderRepository.deleteAll(expired);
        }
    }
}
