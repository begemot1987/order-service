package com.example.order.service.mapper;

import com.example.order.dto.request.OrderRequestDto;
import com.example.order.dto.response.OrderResponseDto;
import com.example.order.model.Item;
import com.example.order.model.Order;
import com.example.order.service.ItemService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper implements RequestDtoMapper<OrderRequestDto, Order>,
        ResponseDtoMapper<OrderResponseDto, Order> {
    private final ItemService itemService;

    public OrderDtoMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public Order toModel(OrderRequestDto requestDto) {
        Order order = new Order();
        Item item = itemService.getById(requestDto.getProductId());
        order.setQuantity(requestDto.getQuantity());
        order.setItem(item);
        order.setPrice(requestDto.getQuantity() * item.getPrice());
        order.setOrderTime(LocalDateTime.now());
        return order;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setQuantity(order.getQuantity());
        responseDto.setPrice(order.getPrice());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setItemId(order.getItem().getId());
        return responseDto;
    }
}
