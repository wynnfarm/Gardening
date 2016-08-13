package com.wynnfarm.watersystem;

public enum ThingSpeakEnum {

	APIKey("U06WBGKFEJHXQB59"), ThingSpeakURL("PUT http://api.thingspeak.com/channels/143256");
		
	private String value;
	
	ThingSpeakEnum(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value ;
	}
	
}

