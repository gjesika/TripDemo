package com.example.tripdemo.login;
import com.example.tripdemo.database.entities.Flight;
import com.example.tripdemo.database.entities.Trip;
import com.example.tripdemo.enums.StatusEnum;
import com.example.tripdemo.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @GetMapping("/getTrips")
    private List<Trip> getAllTrips()
    {
        return tripService.getTrips();
    }

    @PostMapping("/addTrip")
    private void save(@RequestBody Trip trip ){

        tripService.saveOrUpdate(trip);
    }

    @DeleteMapping("/deleteTrip/{tripid}")
    private void deleteBook(@PathVariable("tripid") Long tripid)
    {

        tripService.deleteById(tripid);
    }

    @PostMapping("/statusApproved")
    public String statusApproved(@RequestParam Long id){

        return tripService.statusApproved(id);
    }

    @PostMapping("/statusWaiting")
    public String statusWaiting(@RequestParam Long id) {

        return tripService.statusWaiting(id);
    }

    @PostMapping("/addFlightToTrip")
    public String addFlightToTrip(@RequestParam Long id,@RequestBody List<Flight> flights){

        return tripService.addFlightToTrip(id,flights);

    }














}
