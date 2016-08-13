package com.wynnfarm.watersystem;

public class MoistureReading {

	private double moisture;
	private double temperature;
	private String date;
	
	MoistureReading(double moistureIn, double temperatureIn, String dateIn){
		this.moisture = moistureIn;
		this.temperature = temperatureIn;
		this.date = dateIn;
	}

	public double getMoisture() {
		return moisture;
	}

	public double getTemperature() {
		return temperature;
	}

	public String getDate() {
		return date;
	}
	
}
