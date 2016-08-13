package com.wynnfarm.watersystem;

import org.junit.Test;

public class SolenoidTest {

	
	@Test
	public void runSolenoid() throws InterruptedException{
		Solenoid sole = new Solenoid();
		sole.doSomething();
		
	}
}
