package com.irctc.TrainSystem;

import com.irctc.TrainSystem.Modal.FoodOrder;
import com.irctc.TrainSystem.Modal.Passenger;
import com.irctc.TrainSystem.Modal.Train;
import com.irctc.TrainSystem.Service.PassengerService;
import com.irctc.TrainSystem.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PassengerService passengerService;
    @Autowired
    TrainService trainService;

    @PostMapping("addtrain")
    public String addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
    @PostMapping("addpassenger")
    public String addPassenger(@RequestBody Passenger passenger){
        return passengerService.addPassenger(passenger);
    }
    @PostMapping("addfood")
    public String addFood(@RequestBody FoodOrder foodOrder){
        return passengerService.addFood(foodOrder);
    }
    @GetMapping("getpassengercount")
    public int getPassengercount(@RequestParam String x , @RequestParam String y , @RequestParam String date){
        return passengerService.getPassengercount(x,y,date);
    }
    @GetMapping("getpassengerfemale")
    public int getFemalePassengercount(@RequestParam int x ,@RequestParam int y ,@RequestParam String dest){
        return passengerService.getFemalePassengercount(x,y,dest);
    }
    @GetMapping("totalprice")
    public int getTotalPrice(@RequestParam int trainid,@RequestParam String date){
        return passengerService.getTotalPrice(trainid,date);
    }
}
