package com.irctc.TrainSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Train,Integer> {

}
