package com.irctc.TrainSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tickedId;
    private int trainId;
    private String date;
    private int age;
    private String gender;

    @ManyToOne
    @JoinColumn
    Train train;

    @OneToMany(mappedBy = "passenger",cascade = CascadeType.ALL)
    List<FoodOrder> foodOrderList = new ArrayList<>();

}
