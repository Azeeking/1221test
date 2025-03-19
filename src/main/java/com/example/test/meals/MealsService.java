package com.example.test.meals;

import com.example.test.utils.DailyCaloriesResponse;

import java.util.List;

public interface MealsService {
    MealsDto add(MealsDto dto);
    DailyCaloriesResponse<MealsDto> getDailyMeals(Long userId);
    List<MealsDto> getMealsHistory(Long userId);
    boolean isCaloriesLimit(Long userId);
}
