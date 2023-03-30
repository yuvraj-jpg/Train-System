package com.irctc.TrainSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodOrder {
    private int ticketId;
    private int trainId;
    private int price;

}
