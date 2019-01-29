package com.makemytrip.server.controller.flighdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.server.flightdata.repository.FlightRepository;
import com.makemytrip.server.model.FlightData;
import com.makemytrip.server.supportclass.flighdata.SequenceGeneratorService;

@RestController
public class FlightController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	SequenceGeneratorService sequenceGenerator;

	
	@RequestMapping(method = RequestMethod.POST, value = "/flights/create")
	public String create(@RequestBody FlightData flight) {
		if(flight!=null) {
			flight.setFlightId((sequenceGenerator.generateSequence(FlightData.SEQUENCE_NAME)));
			flightRepository.save(flight);
			return "Flight Added Successfully";
		}
		else 
			return "Unbale to add Flight";
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/flights/get")
	public List<FlightData> FlightsList() {
		return flightRepository.findAll();
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/flights/get/{flightId}")
	public FlightData getFlight(@PathVariable Long flightId) {
		List<FlightData> flights=flightRepository.findAll();
		for (FlightData list1 : flights) {

			if (list1.getFlightId()==flightId) {
				return list1;
			}
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/flights/update/{flightId}")
	public boolean updateFlight(@RequestBody FlightData flight, @PathVariable long flightId) {

		List<FlightData> flights=flightRepository.findAll();

		for (FlightData Obj : flights) {
			if(Obj.getFlightId()==flightId) {
				flight.setFlightId(flightId);
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
		List<FlightData> flights=flightRepository.findAll();

		for (FlightData flight : flights) {


			if(flight.getFlightId()==flightId) {
				flightRepository.deleteById(flightId);
				return "flight deleted";
			}


		}			
		return " unable to delete flight with id "+flightId;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/flights/deleteAll")
	public String deleteall() {
		List<FlightData> flights=flightRepository.findAll();
		if(flights.size()>=1) {
			flightRepository.deleteAll();
			return "All flights deleted successfully";
		}
		else
			return "Unable to delete all flights";
	}
	@RequestMapping(method = RequestMethod.GET,value="/flights/source/{source}/destination/{destination}")
	public List<FlightData> searchFlight(@PathVariable String source ,@PathVariable String destination) {
		List<FlightData> flights=flightRepository.findAll();
		List<FlightData> resultedFlights=new ArrayList<FlightData>();
		for (FlightData flight : flights) {
			if(CheckSource(source)&& CheckDestination(destination)) {
				resultedFlights.add(flight);
				return resultedFlights;
			}		
	}
		return resultedFlights;
}
}
