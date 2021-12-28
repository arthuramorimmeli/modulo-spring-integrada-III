package com.wave4.restaurante.services.implement;

import com.wave4.restaurante.RestauranteApplication;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.entities.Order;
import com.wave4.restaurante.services.interfaces.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplement implements CrudInterface<Order> {

    @Override
    public Order create(Order order) {
        RestauranteApplication.getOrders().add(order);
        return order;
    }

    @Override
    public Order edit(Order order) {
        return null;
    }

    @Override
    public void remove(Order order) {
        RestauranteApplication.getOrders().remove(order);
    }

    @Override
    public void remove(Long i) {
        Order orderToRemove = RestauranteApplication.getOrders().stream()
                .filter(order -> order.getId().equals(i)).collect(Collectors.toList()).get(0);
        RestauranteApplication.getOrders().remove(orderToRemove);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(RestauranteApplication.getOrders());
    }

    @Override
    public Order findById(Long id) {
        return RestauranteApplication.getOrders().stream().filter(order -> order.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public boolean addDishOnOrder(Long dishId, Long orderId) {
        if (orderId != null && dishId != null) {
            Dish dish = RestauranteApplication.getDishes().get(dishId);
            RestauranteApplication.getOrders().forEach(order -> {
                if (order.getId().equals(dish.getId())) {
                    order.addDishOnTable(dish);
                }
            });
        return true;
        }
        return false;
    }

    public List<Order> findOrdersByTableId(Long id) {
        return RestauranteApplication.getOrders().stream().filter(order -> order.getTable().getId().equals(id)).collect(Collectors.toList());
    }

    public List<Order> findOrdersByTableName(String name) {
        return RestauranteApplication.getOrders().stream().filter(order -> order.getTable().getName().equals(name)).collect(Collectors.toList());
    }

}
