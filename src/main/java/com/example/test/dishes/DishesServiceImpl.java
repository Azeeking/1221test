package com.example.test.dishes;

import com.example.test.user.UserData;
import com.example.test.user.UserDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishesServiceImpl implements DishesService {
    @Autowired
    private DishesRepository repository;
    @Autowired
    private DishesMapper mapper;

    @Override
    public DishesDto add(DishesDto dto) {
        DishesData dish = new DishesData();
        dish.setName(dto.getName());
        dish.setCalories(dto.getCalories());
        dish.setProteins(dto.getProteins());
        repository.save(dish);
        return findById(dish.getId());
    }

    public DishesDto findById(Long id) {
        Optional<DishesData> data = repository.findById(id);
        DishesData dishesData = data.orElseThrow(() ->
                new EntityNotFoundException("Dish not found with id: " + id));
        return mapper.toDto(dishesData);
    }
}
