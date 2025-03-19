package com.example.test.dishes;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishesMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "calories", target = "calories")
    @Mapping(source = "proteins", target = "proteins")
    DishesDto toDto(DishesData data);
}
