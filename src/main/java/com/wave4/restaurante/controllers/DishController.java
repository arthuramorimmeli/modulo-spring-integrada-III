package com.wave4.restaurante.controllers;

import com.wave4.restaurante.dtos.DishDTO;
import com.wave4.restaurante.entities.Dish;
import com.wave4.restaurante.services.implement.DishServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishServiceImplement dishServiceImplement;

    @PostMapping
    public ResponseEntity<Dish> create(@RequestBody DishDTO dishDTO) {
        try {
            return ResponseEntity.ok(dishServiceImplement.create(dishDTO.convert()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAll() {
        try {
            return ResponseEntity.ok(dishServiceImplement.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Dish> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(dishServiceImplement.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
