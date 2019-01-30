package com.makemytrip.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.makemytrip.data.model.FlightDetails;
import com.makemytrip.data.model.SearchFlights;




@RestController
@CrossOrigin("*")
public class FlightController1 {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	//returns all  flight from flight details collection
	@GetMapping("/flights")
	public List<FlightDetails> getAllflights(){
		
		List<FlightDetails> users=mongoTemplate.findAll(FlightDetails.class);
		if(users==null) {
			// throw new NoUserExistException("No User Exist");
		}
		return users;
	}
	
	//Remove document that match the provided id from the user collection
		@DeleteMapping("/flights/{flightId}")
		public boolean deleteFlight(@PathVariable long flightId) {
			
			FlightDetails flightDetails=mongoTemplate.findById(flightId, FlightDetails.class);
			if(flightDetails==null) {
				// throw new UserNotExistException("User Not Exist");
			}
			
			return mongoTemplate.remove(new Query(Criteria.where("flightId").is(flightId)), FlightDetails.class).wasAcknowledged();
		}
		
		//update the provided object in flight detail  collection
		@PutMapping("/flights/{flightId}")
		public boolean updateFlight(@PathVariable long flightId,@RequestBody FlightDetails flightDetails) {
			
		  mongoTemplate.save(flightDetails);
		  return true;
		}
		
		
		
	


	//returns flight object from flight details collection that matches the flight name
	/*
	 * @GetMapping("flights/search") public List<FlightDetails>
	 * getAllflights(@PathVariable String source ) {
	 * 
	 * User user=mongoTemplate.findAll(entityClass) //(new
	 * Query(Criteria.where("email").is(email)), User.class) if(user==null) { throw
	 * new UserNotExistException("User Not Exist"); } return user; }
	 */
}

