package com.example.test.meals;

import com.example.test.dishes.DishesData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MealsMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "mealType", target = "mealType")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "dishes", target = "dishesIds")
    MealsDto toDto(MealsData data);

    default List<Long> mapDishesToIds(List<DishesData> dishes) {
        if (dishes == null) {
            return Collections.emptyList(); // Возвращаем пустой список вместо null
        }
        return dishes.stream()
                .map(DishesData::getId)
                .collect(Collectors.toList());
    }
}
