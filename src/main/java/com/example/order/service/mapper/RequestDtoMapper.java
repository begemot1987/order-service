package com.example.order.service.mapper;

public interface RequestDtoMapper<D, T> {
    T toModel(D d);
}
