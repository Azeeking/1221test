package com.example.test.meals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealsRepository extends JpaRepository<MealsData, Long> {
    @Query("SELECT m FROM MealsData m WHERE m.user.id = :userId AND DATE(m.date) = :date")
    List<MealsData> findAllByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);

    @Query("SELECT COUNT(m) FROM MealsData m WHERE m.user.id = :userId AND DATE(m.date) = :date")
    Integer countAllByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);
    @Query("SELECT SUM(d.calories) FROM MealsData m JOIN m.dishes d WHERE m.user.id = :userId AND DATE(m.date) = :date")
    Long sumAllCaloriesByUserIdAndDate(@Param("userId") Long userId, @Param("date") LocalDate date);

    List<MealsData> findAllByUserId(Long userId);
}
