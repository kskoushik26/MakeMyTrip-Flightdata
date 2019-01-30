package com.makemytrip.data.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.data.model.FlightDetails;
import com.makemytrip.data.repository.FlightRepository;
import com.makemytrip.data.supportclass.SequenceGeneratorService;


//@RestController
public class FlightController {

	/*@Autowired
	FlightRepository flightRepository;

	@Autowired
	SequenceGeneratorService sequenceGenerator;

	
	@RequestMapping(method = RequestMethod.POST, value = "/flights/create")
	public String create(@RequestBody FlightDetails flight) {
		if(flight!=null) {
			//flight.setId((sequenceGenerator.generateSequence(FlightDetails.SEQUENCE_NAME)));
			flightRepository.save(flight);
			return "Flight Added Successfully";
		}
		else 
			return "Unbale to add Flight";
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/flights/get")
	public List<FlightDetails> FlightsList() {
		return flightRepository.findAll();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/flights/get/{flightId}")
	public FlightDetails getFlight(@PathVariable Long flightId) {
		List<FlightDetails> flights=flightRepository.findAll();
		for (FlightDetails list1 : flights) {

			if (list1.getId()==flightId) {
				return list1;
			}
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/flights/update/{flightId}")
	public boolean updateFlight(@RequestBody FlightDetails flight, @PathVariable long flightId) {

		List<FlightDetails> flights=flightRepository.findAll();

		for (FlightDetails Obj : flights) {
			if(Obj.getId()==flightId) {
				flight.setId(flightId);
				flightRepository.save(flight);

				return true;
			}
		}
		return false;
	}

	@RequestMapping(method = RequestMethod.GET,value="/flights/source/{source}")
	public boolean CheckSource(@PathVariable String source) {
		return flightRepository.existsBySource(source);
	}

	@RequestMapping(method = RequestMethod.GET,value="/flights/destination/{destination}")
	public boolean CheckDestination(@PathVariable String destination) {
		return flightRepository.existsByDestination(destination);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/flights/delete/{flightId}")
	public String deleteFlight(@PathVariable long flightId) {
		List<FlightDetails> flights=flightRepository.findAll();

		for (FlightDetails flight : flights) {


			if(flight.getId()==flightId) {
				flightRepository.delete(flightId);
				return "flight deleted";
			}


		}			
		return " unable to delete flight with id "+flightId;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/flights/deleteAll")
	public String deleteall() {
		List<FlightDetails> flights=flightRepository.findAll();
		if(flights.size()>=1) {
			flightRepository.deleteAll();
			return "All flights deleted successfully";
		}
		else
			return "Unable to delete all flights";
	}
	@RequestMapping(method = RequestMethod.GET,value="/flights/source/{source}/destination/{destination}")
	public List<FlightDetails> searchFlight(@PathVariable String source ,@PathVariable String destination) {
		List<FlightDetails> flights=flightRepository.findAll();
		List<FlightDetails> resultedFlights=new ArrayList<FlightDetails>();
		for (FlightDetails flight : flights) {
			if(CheckSource(source)&& CheckDestination(destination)) {
				resultedFlights.add(flight);
				return resultedFlights;
			}		
	}
		return resultedFlights;
}*/
}
