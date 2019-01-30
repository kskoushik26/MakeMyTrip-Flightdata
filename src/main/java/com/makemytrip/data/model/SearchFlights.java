package com.makemytrip.data.model;

import java.util.Date;

public class SearchFlights 
{
	private String source;
	private String destination;
	private Date departure;
	
	
	public SearchFlights() {
		super();
	}


	public SearchFlights(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
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


	public Date getDeparture() {
		return departure;
	}


	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	
	
	

}
