package com.example.test.dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishesController {
    @Autowired
    private DishesServiceImpl dishesService;

    @PostMapping
    public ResponseEntity<DishesDto> createDish(@RequestBody DishesDto dto) {
        DishesDto dishesDto = dishesService.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dishesDto);
    }
}
