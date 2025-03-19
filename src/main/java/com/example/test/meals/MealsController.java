package com.example.test.meals;

import com.example.test.utils.DailyCaloriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealsController {
    @Autowired
    private MealsServiceImpl mealsService;

    @PostMapping
    public ResponseEntity<MealsDto> addMeal(@RequestBody MealsDto mealsDto) {
        return ResponseEntity.ok(mealsService.add(mealsDto));
    }

    @GetMapping("/daily/{userId}")
    public ResponseEntity<DailyCaloriesResponse<MealsDto>> getDailyMeals(@PathVariable Long userId) {
        return ResponseEntity.ok(mealsService.getDailyMeals(userId));
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<MealsDto>> getMealHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(mealsService.getMealsHistory(userId));
    }

    @GetMapping("/check/{userId}")
    public ResponseEntity<Boolean> isUnderCalorieLimit(@PathVariable Long userId) {
        return ResponseEntity.ok(mealsService.isCaloriesLimit(userId));
    }
}
