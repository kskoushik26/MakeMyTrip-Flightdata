package com.makemytrip.data.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.makemytrip.data.supportclass.DateHandler;
//@Document(collection="FlightDetails")
@Entity
public class FlightDetails 
{
	/*@Transient
    public static final String SEQUENCE_NAME = "users_sequence";*/
	@Id
	private long id;
	private String flightName;
	private String source;
	private String destination;
	@JsonDeserialize(using =DateHandler.class)
	private Date arrival;
	@JsonDeserialize(using =DateHandler.class)
	private Date departure;
	private double price;
	
	public FlightDetails() {
		super();
	}

	public FlightDetails(long id, String flightName, String source, String destination, Date arrival, Date departure,
			double price) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.arrival = arrival;
		this.departure = departure;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long flightId) {
		this.id = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	
	
}
