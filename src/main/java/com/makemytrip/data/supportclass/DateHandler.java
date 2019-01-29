package com.makemytrip.data.supportclass;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@SuppressWarnings("serial")
public class DateHandler extends StdDeserializer<Date> {

	public DateHandler(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}
 
	public DateHandler() {
	this(null);	// TODO Auto-generated constructor stub
	}
	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		String date=p.getText();
		try {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-dd");
			return sdf.parse(date);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}

}
