package com.irctc.TrainSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Service service;

    //POST API - Add a Passenger with ticketId, trainId, Date, Age, Gender
    @PostMapping("/addpassenger")
    public String addPassenger(@RequestBody Passenger passenger){
        return service.addPassenger(passenger);
    }
//POST API - Add a Train with trainNo, Source, Destination
    @PostMapping("/addtrain")
    public String addTrain(@RequestBody Train train){
        return service.addTrain(train);
    }
//GET API - Find the Number of passengers traveling from City X and City Y on Date D.

//GET API - Find total No of female passengers of age between X and Y(X < = Y) who ended at their destination at city C.
//GET API - Get the total price of the orders placed by Customers on Date D in TrainId T.
    @GetMapping("/getpassenger")
    public int getPassenger(String x , String y , String date) {
        return service.getPassenger(x,y,date);
    }
    @GetMapping("/getfemalepassenger")
    public int getFemalePassenger(int x , int y , String c)  {
        return service.getFemalePassenger(x,y,c);
    }
    @GetMapping("/orderplaced")
    public int OrderPlaced(String d,int trainId){
        return service.OrderPlaced(d,trainId);
    }
}
