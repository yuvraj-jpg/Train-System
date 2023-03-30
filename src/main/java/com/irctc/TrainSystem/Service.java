package com.irctc.TrainSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    Repository repository;
    public String addPassenger(Passenger passenger){
        return repository.addPassenger(passenger);
    }
    public String addTrain(Train train){
        return repository.addTrain(train);
    }
    public int getPassenger(String x , String y , String date) {
        return repository.getPassenger(x,y,date);
    }
    public int getFemalePassenger(int x , int y , String c)  {
        return repository.getFemalePassenger(x,y,c);
    }
    public int OrderPlaced(String d,int trainId){
        return repository.OrderPlaced(d,trainId);
    }
}
