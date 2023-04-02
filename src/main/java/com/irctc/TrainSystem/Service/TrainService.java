package com.irctc.TrainSystem.Service;

import com.irctc.TrainSystem.Modal.Train;
import com.irctc.TrainSystem.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;
    public String addTrain(Train train){
        trainRepository.save(train);
        return "Train Added";
    }

}
