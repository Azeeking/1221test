package com.example.test.dishes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishesDto {
    private Long id;
    private String name;
    private Double calories;
    private Double proteins;
}
