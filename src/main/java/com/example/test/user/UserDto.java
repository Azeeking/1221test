package com.example.test.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    @Min(value = 20, message = "Вес должен быть не менее 20 кг")
    @Max(value = 300, message = "Вес должен быть не более 300 кг")
    private Double weight;
    @Min(value = 50, message = "Рост должен быть не менее 50 см")
    @Max(value = 250, message = "Рост должен быть не более 250 см")
    private Double height;
    private String purpose;
    private Double dailyCaloriesGoal;
}
