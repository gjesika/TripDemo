package com.example.tripdemo.services;

import com.example.tripdemo.database.entities.Flight;
import com.example.tripdemo.database.entities.Trip;
import com.example.tripdemo.database.repository.FlightRepository;
import com.example.tripdemo.database.repository.TripRepository;
import com.example.tripdemo.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService{

    @Autowired
    TripRepository tripRepository ;
    @Autowired
    FlightRepository flightRepository;

    public List<Trip> getTrips(){

        return tripRepository.findAll();
    }

    public void saveOrUpdate(Trip tripEntity)
    {
        tripEntity.setStatus(StatusEnum.CREATED);
        tripRepository.save(tripEntity);
    }

    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }

    public String statusWaiting(Long Id){
        Optional<Trip> trip = tripRepository.findById(Id);
        if(trip.isPresent()){
            Trip existingTrip = trip.get();
            existingTrip.setStatus(StatusEnum.WAITING_FOR_APPROVAL);
            tripRepository.save(existingTrip);
            return "Staus Wating For Approval" ;
        }
        else return "Trip Not Present" ;
    }

    public String statusApproved(Long Id){
        Optional<Trip> trip = tripRepository.findById(Id);
        if(trip.isPresent()){
            Trip existingTrip = trip.get();
            existingTrip.setStatus(StatusEnum.APPROVED);
            tripRepository.save(existingTrip);
            return "Staus Approved" ;
        }
        else return "Trip Not Present" ;
    }

   public String addFlightToTrip(Long Id,List<Flight> flights){

        Optional<Trip> trip = tripRepository.findById(Id);

        if(trip.isPresent()) {
            Trip existingTrip = trip.get();
            System.out.println(existingTrip.getStatus());
            if(existingTrip.getStatus()==StatusEnum.APPROVED){
                flights.forEach(flight -> {
                    flight.setTrip(existingTrip);
                    flightRepository.save(flight);
                });
//                existingTrip.setFlights(flights);
//
//                tripRepository.save(existingTrip);

                return "Flights added" ;
            }else {
                return "Can not add flights ,trip not approved " ;
            }

        }
    return "Trip Not Present" ;

   }



}
