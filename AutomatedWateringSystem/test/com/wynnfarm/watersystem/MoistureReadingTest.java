package com.wynnfarm.watersystem;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.angryelectron.thingspeak.Channel;
import com.angryelectron.thingspeak.Entry;
import com.angryelectron.thingspeak.ThingSpeakException;
import com.angryelectron.thingspeak.log4j.ThingSpeakAppender;
import com.mashape.unirest.http.exceptions.UnirestException;

public class MoistureReadingTest {

	
	HTTPConnector connector;
	ThingSpeak ts;
	
	
	@Before
	public void setup(){
		connector = new HTTPConnector();
		ts = new ThingSpeak();
	}
	
//	@Test
//	public void testString(){
//		MoistureReading readingIn = new MoistureReading(75.3, 88.8, "date");
//		String input = "{\"Field1\":" + readingIn.getMoisture() + ",\"Field2\":" + readingIn.getTemperature() +  ",\"Field3\":" + readingIn.getDate()  
//		+ ",\"api_keys\": [ { \"api_key\": \"" + ThingSpeakEnum.APIKey.getValue() + "\", \"write_flag\": true }]";
//		System.out.println(input);
//	}
	
	@Test
	public void canConnectAndSendToThingSpeak() throws IOException, InterruptedException, UnirestException, ThingSpeakException{
		Channel channel = new Channel(143256,"U06WBGKFEJHXQB59");
		Entry entry = new Entry();
		entry.setField(1, "40.3");
		entry.setField(2,  "88.8");
		entry.setField(3, "8/10/16 14:32");
		channel.update(entry);
		
//		
	}
	
	
}
