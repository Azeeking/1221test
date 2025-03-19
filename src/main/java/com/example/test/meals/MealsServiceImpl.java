package com.example.test.meals;

import com.example.test.dishes.DishesData;
import com.example.test.dishes.DishesRepository;
import com.example.test.user.UserData;
import com.example.test.user.UserRepository;
import com.example.test.utils.DailyCaloriesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MealsServiceImpl implements MealsService {
    @Autowired
    private MealsRepository mealsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DishesRepository dishesRepository;
    @Autowired
    private MealsMapper mapper;
    @Override
    public MealsDto add(MealsDto dto) {
        UserData user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<DishesData> dishes = dishesRepository.findAllById(dto.getDishesIds());

        MealsData meal = new MealsData();
        meal.setDate(dto.getDate());
        meal.setMealType(dto.getMealType());
        meal.setUser(user);
        meal.setDishes(dishes);

        MealsData savedMeal = mealsRepository.save(meal);

        return mapper.toDto(savedMeal);
    }

    @Override
    public DailyCaloriesResponse<MealsDto> getDailyMeals(Long userId) {
        int totalCount = mealsRepository.countAllByUserIdAndDate(userId, LocalDate.now());
        double totalCalories = mealsRepository.sumAllCaloriesByUserIdAndDate(userId, LocalDate.now());
        List<MealsDto> meals = mealsRepository.findAllByUserIdAndDate(userId, LocalDate.now()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
            return new DailyCaloriesResponse<>(totalCalories, totalCount, meals);
    }

    @Override
    public List<MealsDto> getMealsHistory(Long userId) {
        List<MealsData> meals = mealsRepository.findAllByUserId(userId);
        return meals.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isCaloriesLimit(Long userId) {
        double totalCalories = mealsRepository.findAllByUserIdAndDate(userId, LocalDate.now())
                .stream()
                .flatMap(meal -> meal.getDishes().stream())
                .mapToDouble(DishesData::getCalories)
                .sum();

        UserData user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return totalCalories >= user.getDailyCaloriesGoal();
    }
}
