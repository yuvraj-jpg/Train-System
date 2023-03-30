package com.irctc.TrainSystem;
import java.util.HashMap;
@org.springframework.stereotype.Repository
public class Repository {
    HashMap<Integer,Train> trainrecord = new HashMap<>();
    HashMap<Integer,Passenger> passengerrecord = new HashMap<>();
    HashMap<Integer,FoodOrder> foodorderrecord = new HashMap<>();
    public String addPassenger( Passenger passenger){
        passengerrecord.put(passenger.getTickedId(),passenger);
        trainrecord.put(passenger.getTrainId(),new Train());
        return "Passenger Added !!!";
    }
    public String addTrain(Train train){
        trainrecord.put(train.getTrainId(),train);
        return "Train Added !!!";
    }
    public String addOrder(FoodOrder foodOrder){
        foodorderrecord.put(foodOrder.getTicketId(),foodOrder);
        passengerrecord.put(foodOrder.getTicketId(),new Passenger());
        trainrecord.put(foodOrder.getTrainId(),new Train());
        return "Order Placed !!!";
    }
    public int getPassenger(String x , String y , String date) {
        int c=0;
     for(Integer id : passengerrecord.keySet()){
         if(passengerrecord.get(id).getDate().equals(date)){
             int abc = passengerrecord.get(id).getTrainId();
             Train train = trainrecord.get(abc);
             if(train.getSource().equals(x) && train.getDestination().equals(y)){
                 c++;
             }
         }
     }
     return c;
    }
    //Find total No of female passengers of age between X and Y(X < = Y) who ended at their destination at city C.
    public int getFemalePassenger(int x , int y , String c)  {
        int count=0;
        for(Integer id : passengerrecord.keySet()){
            int age = passengerrecord.get(id).getAge();
            if(age>x && age<y){
                int trainId = passengerrecord.get(id).getTrainId();
                if(trainrecord.get(trainId).getDestination().equals(c)){
                    count++;
                }
            }
        }
        return count;
    }
    //Get the total price of the orders placed by Customers on Date D in TrainId T.
    public int OrderPlaced(String d,int trainId){
        int total =0;
        for(Integer id : passengerrecord.keySet()){
            if(passengerrecord.get(id).getDate().equals(d)){
              if(foodorderrecord.get(id).getTrainId()==trainId){
                  total += foodorderrecord.get(id).getPrice();
              }
            }
        }
        return total;
    }


}
