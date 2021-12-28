package com.wave4.restaurante.dtos;

import com.wave4.restaurante.dtos.interfaces.ConverterInterface;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO implements ConverterInterface<Dish, DishDTO> {

    private Long id;
    private Double price;
    private String description;


    @Override
    public Dish convert() {
        if (this.id != null) {
            return new Dish(this.id, this.price, this.description);
        } else {
            return new Dish(DateUtils.getCurrentTimeMillis(), this.price, this.description);
        }
    }

    @Override
    public DishDTO convert(Dish dish) {
        this.id = dish.getId();
        this.price = dish.getPrice();
        this.description = dish.getDescription();
        return this;
    }
}
