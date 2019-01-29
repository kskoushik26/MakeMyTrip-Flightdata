package com.makemytrip.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.makemytrip.data.model.FlightDetails;


public interface FlightRepository extends MongoRepository<FlightDetails, Long> {

	boolean existsByDestination(String destination);

	boolean existsBySource(String source);

}
