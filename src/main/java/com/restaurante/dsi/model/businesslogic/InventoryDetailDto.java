package com.restaurante.dsi.model.businesslogic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import java.time.LocalDate;

public interface InventoryDetailDto {
    Long getId();

    Long getInventoryId();
    Double getQuantity();
    Double getPrice();

    Long getIngredientId();
   String getIngredientName();

}

