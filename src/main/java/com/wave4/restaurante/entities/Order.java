package com.wave4.restaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Pedido deve ter id, mesa, lista de pratos solicitados e valor total.
@Getter
@Setter
@AllArgsConstructor
public class Order {

    private Long id;
    private Table table;
    private List<Dish> dishes;
    private Double totalConsumed;

    public void addDishOnTable(Dish dish) {
        this.dishes.add(dish);
        this.setTotalConsumed(calcTotalConsumed());
    }

    public Double calcTotalConsumed() {
        return dishes.stream().mapToDouble(Dish::getPrice).sum();
    }
}
