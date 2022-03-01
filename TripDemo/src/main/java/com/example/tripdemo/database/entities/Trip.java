package com.example.tripdemo.database.entities;
import com.example.tripdemo.enums.StatusEnum;
import com.example.tripdemo.enums.TripReasons;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    @Enumerated(EnumType.STRING)
    private TripReasons tripReasons ;

    @NotNull
    private String description;

    @NotNull
    private Date departuredate;

    @NotNull
    private Date arrivalDate;

    @NotNull
    private String departure;

    @NotNull
    private String arrival ;

    @Enumerated(EnumType.STRING)
    private StatusEnum status ;


    @OneToMany(mappedBy = "trip")
    @ToString.Exclude
    private List<Flight> flights ;



}
