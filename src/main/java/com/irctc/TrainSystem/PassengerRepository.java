package com.irctc.TrainSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {


    @Query(value = " SELECT COUNT(*) FROM passenger p JOIN train t ON p.id = t.trainNo WHERE t.source =:source AND t.destination =:destinationAND p.date =:date", nativeQuery = true)
    int getPassengers(String source, String destination,String date);

    //List<Passenger> FindFemaleByAgeAndDestination(int x ,int y,String destination);
}
