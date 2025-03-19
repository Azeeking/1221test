package com.example.test.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public UserDto add(UserDto userDto) {
        UserData userData = new UserData();
        userData.setName(userDto.getName());
        userData.setEmail(userDto.getEmail());
        userData.setAge(userDto.getAge());
        userData.setHeight(userDto.getHeight());
        userData.setWeight(userDto.getWeight());
        userData.setPurpose(userDto.getPurpose());
        Double calculation = calculateCalorieGoal(userDto.getWeight(), userDto.getHeight(), userDto.getAge());
        userData.setDailyCaloriesGoal(calculation);
        userRepository.save(userData);
        return findById(userData.getId());
    }

    @Override
    public UserDto findById(Long id) {
        Optional<UserData> data = userRepository.findById(id);
        UserData userData = data.orElseThrow(() ->
                new EntityNotFoundException("User not found with id: " + id));
        return mapper.toDto(userData);
    }

    private Double calculateCalorieGoal(double weight, double height, int age) {
        return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
    }
}
