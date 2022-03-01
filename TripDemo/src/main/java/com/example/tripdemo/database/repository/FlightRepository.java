package com.example.tripdemo.database.repository;
import com.example.tripdemo.database.entities.Flight;
import com.example.tripdemo.database.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository <Flight,Long>{


}
