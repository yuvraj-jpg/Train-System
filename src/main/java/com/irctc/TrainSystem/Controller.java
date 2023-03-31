package com.irctc.TrainSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    //POST API - Add a Passenger with ticketId, trainId, Date, Age, Gender
    @Autowired
    Repository repository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FoodOrderRepository foodOrderRepository;
    @PostMapping("/addpassenger")
    public String addPassenger(@RequestBody Passenger passenger){
        passengerRepository.save(passenger);
        return "Passenger Added";
    }
    //POST API - Add a Train with trainNo, Source, Destination
    @PostMapping("/addtrain")
    public String addTrain(@RequestBody Train train){
        repository.save(train);
        return "Train Added";
    }
    @GetMapping("/getpassenger")
    public int getPassenger(@RequestParam String x ,@RequestParam String y ,@RequestParam String date) {
         int ans= passengerRepository.getPassengers(x,y,date);
        return ans;

    }
//    @GetMapping("/getfemalepassenger")
//    public int getFemalePassenger(int x , int y , String c)  {
//        List<Passenger> passengerList = passengerRepository.FindFemaleByAgeAndDestination(x,y,c);
//        return passengerList.size();
//    }
//    @GetMapping("/orderplaced")
//    public int OrderPlaced(String d,int trainId){
//        List<FoodOrder> foodOrderList = foodOrderRepository.findByTrainidAndDate(d,trainId);
//        int total=0;
//        for(FoodOrder foodOrder : foodOrderList){
//            total += foodOrder.getPrice();
//        }
//        return total;
//    }
}