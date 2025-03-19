package com.example.test.dishes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishesRepository extends JpaRepository<DishesData, Long> {
}
