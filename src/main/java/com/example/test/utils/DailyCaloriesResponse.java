package com.example.test.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyCaloriesResponse<T> implements Serializable {
    private Double totalCalories;
    private Integer totalCount;
    private List<T> data;
}
