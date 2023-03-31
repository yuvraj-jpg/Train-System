package com.irctc.TrainSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {
    //List<FoodOrder> findByTrainidAndDate(String date, int id);
}
