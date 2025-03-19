package com.example.test.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "purpose", target = "purpose")
    @Mapping(source = "dailyCaloriesGoal", target = "dailyCaloriesGoal")
    UserDto toDto(UserData data);
}
