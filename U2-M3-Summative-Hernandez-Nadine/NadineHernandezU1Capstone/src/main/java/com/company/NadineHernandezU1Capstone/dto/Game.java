package com.company.NadineHernandezU1Capstone.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Game {
    private Integer game_id;
    @NotEmpty(message = "title cannot be empty")
    @Size(max = 50, message = "title cannot exceed 50 characters")
    private String title;
    @NotEmpty(message = "esrb rating cannot be empty")
    @Size(max = 50, message = "esrb rating cannot exceed 50 characters")
    private String esrb_rating;
    @NotEmpty(message = "description cannot be empty")
    @Size(max = 255, message = "description cannot exceed 255 characters")
    private String description;
    @NotNull(message = "price cannot be null")
    @Min(value = 0, message = "Price must be greater than 0")
    @Digits(integer = 5, fraction = 2, message = "Incorrect price format")
    private BigDecimal price;
    @NotEmpty(message = "studio cannot be empty")
    @Size(max = 50, message = "studio cannot exceed 50 characters")
    private String studio;
    @NotNull(message = "Quantity cannot be null")
    @Min(value = 0, message = "Quantity must be greater than 0")
    private Integer quantity;

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        Game game = (Game) o;
        return Objects.equals(game_id, game.game_id) &&
                title.equals(game.title) &&
                esrb_rating.equals(game.esrb_rating) &&
                description.equals(game.description) &&
                price.equals(game.price) &&
                studio.equals(game.studio) &&
                quantity.equals(game.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, title, esrb_rating, description, price, studio, quantity);
    }
}
