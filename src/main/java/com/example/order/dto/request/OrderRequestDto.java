package com.example.order.dto.request;

public class OrderRequestDto {
    private Long quantity;
    private Long itemId;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return itemId;
    }

    public void setProductId(Long itemId) {
        this.itemId = itemId;
    }
}
