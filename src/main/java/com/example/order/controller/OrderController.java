package com.example.order.controller;

import com.example.order.dto.request.OrderRequestDto;
import com.example.order.dto.response.OrderResponseDto;
import com.example.order.service.OrderService;
import com.example.order.service.mapper.OrderDtoMapper;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderDtoMapper orderDtoMapper;

    public OrderController(OrderService orderService, OrderDtoMapper orderDtoMapper) {
        this.orderService = orderService;
        this.orderDtoMapper = orderDtoMapper;
    }

    @GetMapping
    public List<OrderResponseDto> getAll() {
        return null;
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody OrderRequestDto requestDto) {
        return orderDtoMapper.toDto(orderService.add(orderDtoMapper.toModel(requestDto)));
    }
}
