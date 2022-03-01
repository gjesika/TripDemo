package com.example.tripdemo.database.entities;

import com.example.tripdemo.enums.StatusEnum;
import com.example.tripdemo.enums.TripReasons;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Flight {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;


    private Date departuredate;


    private Date arrivalDate;


    private String departure;


    private String arrival ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    //kjo eshte trip id
    @JoinColumn(name="flightId")
    @ToString.Exclude
    private Trip trip ;

}
