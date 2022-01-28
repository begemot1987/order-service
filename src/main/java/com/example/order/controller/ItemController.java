package com.example.order.controller;

import com.example.order.dto.response.ItemResponseDto;
import com.example.order.service.ItemService;
import com.example.order.service.mapper.ItemDtoMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemDtoMapper dtoMapper;

    public ItemController(ItemService itemService, ItemDtoMapper dtoMapper) {
        this.itemService = itemService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping
    public List<ItemResponseDto> getAll() {
        return itemService.getAll().stream().map(dtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/search")
    public ItemResponseDto getAvailableByItem(@RequestParam String item,
                                              @RequestParam Long quantity) {
        return dtoMapper.toDto(itemService.getCheapestByItem(item, quantity));
    }
}
