package com.wave4.restaurante.controllers;

import com.wave4.restaurante.dtos.AddDishOrderDTO;
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

    @GetMapping(value = "")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            return ResponseEntity.ok(orderServiceImplement.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/table/{mesaId}")
    public ResponseEntity<List<Order>> getAllOrdersByTableId(@PathVariable Long mesaId) {
        try {
            return ResponseEntity.ok(orderServiceImplement.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping(value = "/add-dish")
    public ResponseEntity<Boolean> addDishOnOrder(@RequestBody AddDishOrderDTO addDishOrderDTO) {
        try {
            boolean added = orderServiceImplement.addDishOnOrder(addDishOrderDTO);
            return ResponseEntity.ok(added);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
