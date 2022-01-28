package com.example.order.service.mapper;

import com.example.order.dto.response.ItemResponseDto;
import com.example.order.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoMapper implements ResponseDtoMapper<ItemResponseDto, Item> {
    @Override
    public ItemResponseDto toDto(Item item) {
        ItemResponseDto responseDto = new ItemResponseDto();
        responseDto.setId(item.getId());
        responseDto.setName(item.getName());
        responseDto.setQuantity(item.getQuantity());
        responseDto.setPrice(item.getPrice());
        return responseDto;
    }
}
