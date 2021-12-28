package com.wave4.restaurante;

import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.entities.Order;
import com.wave4.restaurante.entities.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class RestauranteApplication {

    private static Map<Long, Table> tables = new HashMap<>();
    private static Map<Long, Dish> dishes = new HashMap<>();
    private static Set<Order> orders = new HashSet<>();

    public static void main(String[] args) {
        SpringApplication.run(RestauranteApplication.class, args);
    }

    public static Map<Long, Table> getTables() {
        return tables;
    }

    public static Map<Long, Dish> getDishes() {
        return dishes;
    }

    public static Set<Order> getOrders() {
        return orders;
    }
}
