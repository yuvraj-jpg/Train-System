package com.irctc.TrainSystem.Service;

import com.irctc.TrainSystem.Modal.FoodOrder;
import com.irctc.TrainSystem.Modal.Passenger;
import com.irctc.TrainSystem.Modal.Train;
import com.irctc.TrainSystem.Repository.FoodOrderRepository;
import com.irctc.TrainSystem.Repository.PassengerRepository;
import com.irctc.TrainSystem.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    TrainRepository trainRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FoodOrderRepository foodOrderRepository;

    public String addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
        return "Passenger added";
    }
    public String addFood(FoodOrder foodOrder){
        foodOrderRepository.save(foodOrder);
        return "food order placed";
    }

    public int getPassengercount(String x ,String y , String date){
        List<Passenger> passengerList = passengerRepository.findAll();
        int c=0;
        for(Passenger passenger : passengerList){
            Train train = trainRepository.findById(passenger.getTrainid()).get();
            if(train.getSource().equals(x) && train.getDestination().equals(y) && passenger.getDate().equals(date)){
                c++;
            }
        }
        return c;
    }
    public int getFemalePassengercount(int x ,int y , String dest){
        List<Passenger> passengerList = passengerRepository.findAll();
        int c=0;
        for(Passenger passenger : passengerList) {
            Train train = trainRepository.findById(passenger.getTrainid()).get();
            if (passenger.getGender().equals("female")) {
                if (passenger.getAge() >= x && passenger.getAge() <= y) {
                    if (train.getDestination().equals(dest)) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
    public int getTotalPrice(int trainid,String date){
        List<FoodOrder> foodOrderList = foodOrderRepository.findAll();
        int total=0;
        for(FoodOrder foodOrder : foodOrderList){
            Passenger passenger = passengerRepository.findById(foodOrder.getPassengerId()).get();
            if(foodOrder.getTrainId()==trainid && passenger.getDate().equals(date)){
                total+=foodOrder.getPrice();
            }
        }
        return total;
    }
}
