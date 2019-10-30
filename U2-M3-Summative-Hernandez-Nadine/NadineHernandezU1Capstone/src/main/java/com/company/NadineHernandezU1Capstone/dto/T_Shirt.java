package com.company.NadineHernandezU1Capstone.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class T_Shirt {
    private Integer t_shirt_id;
    @NotEmpty(message = "size cannot be empty")
    @Size(max = 20, message = "size cannot exceed 20 characters")
    private String size;
    @NotEmpty(message = "color cannot be empty")
    @Size(max = 20, message = "color cannot exceed 20 characters")
    private String color;
    @NotEmpty(message = "description cannot be empty")
    @Size(max = 255, message = "description cannot exceed 255 characters")
    private String description;
    @NotNull(message = "price cannot be null")
    @Min(value = 0, message = "Price must be greater than 0")
    @Digits(integer = 5, fraction = 2, message = "Incorrect price format")
    private BigDecimal price;
    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private Integer quantity;

    public Integer getT_shirt_id() {
        return t_shirt_id;
    }

    public void setT_shirt_id(Integer t_shirt_id) {
        this.t_shirt_id = t_shirt_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_Shirt t_shirt = (T_Shirt) o;
        return Objects.equals(t_shirt_id, t_shirt.t_shirt_id) &&
                size.equals(t_shirt.size) &&
                color.equals(t_shirt.color) &&
                description.equals(t_shirt.description) &&
                price.equals(t_shirt.price) &&
                quantity.equals(t_shirt.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t_shirt_id, size, color, description, price, quantity);
    }
}
