package com.restaurante.dsi.model.businesslogic;

public interface InventoryDetailDto {
    Long getId();

    Long getInventoryId();
    Double getQuantity();
    Double getPrice();
    Integer getMinStock();
    Long getIngredientId();
   String getIngredientName();

}

