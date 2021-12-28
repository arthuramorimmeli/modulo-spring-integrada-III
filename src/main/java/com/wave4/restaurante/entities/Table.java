package com.wave4.restaurante.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    private Long id;
    private String name;
    private Double totalConsumed;

}
