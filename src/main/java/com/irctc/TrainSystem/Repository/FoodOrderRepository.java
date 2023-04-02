package com.irctc.TrainSystem.Repository;

import com.irctc.TrainSystem.Modal.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {

}
