package com.wave4.restaurante.services.implement;

import com.wave4.restaurante.RestauranteApplication;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.services.interfaces.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImplement implements CrudInterface<Dish> {

    @Override
    public Dish create(Dish dish) {
        RestauranteApplication.getDishes().put(dish.getId(), dish);
        return dish;
    }

    @Override
    public Dish edit(Dish dish) {
        return null;
    }

    @Override
    public void remove(Dish dish) {
        RestauranteApplication.getDishes().remove(dish.getId());
    }

    @Override
    public void remove(Long i) {
        RestauranteApplication.getDishes().remove(i);
    }

    @Override
    public List<Dish> findAll() {
        return new ArrayList<>(RestauranteApplication.getDishes().values());
    }

    @Override
    public Dish findById(Long id) {
        return RestauranteApplication.getDishes().get(id);
    }

}
