package com.wave4.restaurante.entities;
//Prato deve ter id, preço, descrição, quantidade.

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private Long id;
    private Double price;
    private String description;

}
