package com.wave4.restaurante.services.implement;

import com.wave4.restaurante.RestauranteApplication;
import com.wave4.restaurante.dtos.AddDishOrderDTO;
import com.wave4.restaurante.dtos.DishDTO;
import com.wave4.restaurante.dtos.OrderDTO;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.entities.Order;
import com.wave4.restaurante.services.interfaces.CrudInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplement implements CrudInterface<Order, OrderDTO> {

    @Override
    public Order create(OrderDTO orderDTO) {
        Order order = orderDTO.convert();
        RestauranteApplication.getOrders().add(order);
        return order;
    }

    @Override
    public Order edit(Order order, OrderDTO orderDTO) {
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

    public boolean addDishOnOrder(AddDishOrderDTO addDishOrderDTO) {
        if (addDishOrderDTO.getOrderId() != null && addDishOrderDTO.getDishId() != null) {
            Dish dish = RestauranteApplication.getDishes().get(addDishOrderDTO.getDishId());
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

}
