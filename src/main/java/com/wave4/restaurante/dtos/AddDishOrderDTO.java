package com.wave4.restaurante.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDishOrderDTO {

    private Long dishId;
    private Long orderId;
}
