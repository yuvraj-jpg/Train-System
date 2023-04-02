package com.irctc.TrainSystem.Repository;
import com.irctc.TrainSystem.Modal.Train;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {

}
