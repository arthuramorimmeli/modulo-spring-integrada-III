package com.wave4.restaurante.controllers;

import com.wave4.restaurante.dtos.TableDTO;
import com.wave4.restaurante.entities.Table;
import com.wave4.restaurante.services.implement.TableServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController{

    @Autowired
    private TableServiceImplement tableServiceImplement;

    @PostMapping
    public ResponseEntity<Table> create(@RequestBody TableDTO tableDTO) {
        try {
            return ResponseEntity.ok(tableServiceImplement.create(tableDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Table>> getAll() {
        try {
            return ResponseEntity.ok(tableServiceImplement.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Table> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableServiceImplement.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
