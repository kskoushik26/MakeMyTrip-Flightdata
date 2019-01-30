package com.makemytrip.data.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.makemytrip.data.exception.FlightNotFoundException;
import com.makemytrip.data.exception.NoFlightFoundException;
import com.makemytrip.data.model.FlightDetails;
import com.makemytrip.data.model.SearchFlights;

import com.makemytrip.data.service.SequenceService;




@RestController
@CrossOrigin("*")
public class FlightController1 {

	private final String KEY="flight-details";

	@Autowired
	private SequenceService seqId;

	@Inject
	private MongoTemplate mongoTemplate;
	
	@Inject
	private MongoOperations mongoOperations;

	//returns all  flight from flight details collection
	@GetMapping("/flights")
	public List<FlightDetails> getAllflights(){

		List<FlightDetails> flights=mongoTemplate.findAll(FlightDetails.class);
		if(flights==null) {
			throw new NoFlightFoundException("No Flight Exist");
		}
		return flights;
	}

	//Remove document that match the provided id from the user collection
	@DeleteMapping("/flights/{flightId}")
	public boolean deleteFlight(@PathVariable long flightId) {

		FlightDetails flightDetails=mongoTemplate.findById(flightId, FlightDetails.class);
		if(flightDetails==null) {
			throw new FlightNotFoundException("Flight Not Exist");
		}

		return mongoTemplate.remove(new Query(Criteria.where("id").is(flightId)), FlightDetails.class).wasAcknowledged();
	}

	//update the provided object in flight detail  collection
	@PutMapping("/flights/{flightId}")
	public FlightDetails updateFlight(@PathVariable long flightId,@RequestBody FlightDetails flightDetails) {

		FlightDetails flight=mongoTemplate.findById(flightId, FlightDetails.class);
		if(flight==null) {
			throw new FlightNotFoundException("Flight not found to update ");
		}

		flightDetails.setId(flight.getId());
		mongoTemplate.save(flightDetails);

		return flightDetails;
	}


	//save the provided flight-details object in FlightDetails collection and returns same object back
	@PostMapping("/flights")
	public FlightDetails saveFlightDetails(@RequestBody FlightDetails flightDetails) {

		flightDetails.setId(seqId.getNextSequenceId(KEY));

		mongoTemplate.save(flightDetails);

		return flightDetails;

	}

	



}

