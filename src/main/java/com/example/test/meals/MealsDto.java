package com.example.test.meals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealsDto {
    private Long id;
    private LocalDate date;
    private String mealType;
    private Long userId;
    private List<Long> dishesIds;
}
