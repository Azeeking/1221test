package com.example.test.user;

public interface UserService {
    UserDto add(UserDto userDto);
    UserDto findById(Long id);
}
