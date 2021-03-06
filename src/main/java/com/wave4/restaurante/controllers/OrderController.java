package com.wave4.restaurante.controllers;

import com.wave4.restaurante.dtos.AddDishOrderDTO;
import com.wave4.restaurante.dtos.OrderDTO;
import com.wave4.restaurante.entities.Order;
import com.wave4.restaurante.services.implement.OrderServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServiceImplement orderServiceImplement;

    @PostMapping(value = "")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            return ResponseEntity.ok(orderServiceImplement.create(orderDTO.convert()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping(value = "")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            return ResponseEntity.ok(orderServiceImplement.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/table/{tableName}")
    public ResponseEntity<List<Order>> getAllOrdersByTableId(@PathVariable String tableName) {
        try {
            return ResponseEntity.ok(orderServiceImplement.findOrdersByTableName(tableName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping(value = "/table/{tableId}")
    public ResponseEntity<List<Order>> getAllOrdersByTableId(@PathVariable Long tableId) {
        try {
            return ResponseEntity.ok(orderServiceImplement.findOrdersByTableId(tableId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/add-dish")
    public ResponseEntity<Boolean> addDishOnOrder(@RequestBody AddDishOrderDTO addDishOrderDTO) {
        try {
            boolean added = orderServiceImplement.addDishOnOrder(addDishOrderDTO.getDishId(), addDishOrderDTO.getOrderId());
            return ResponseEntity.ok(added);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
