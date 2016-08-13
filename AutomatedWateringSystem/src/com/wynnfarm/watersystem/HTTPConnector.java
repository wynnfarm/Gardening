package com.wynnfarm.watersystem;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnector {

	public void connectThingSpeak(MoistureReading readingIn) throws IOException, InterruptedException{
			String output = "{\"Field1\":" + readingIn.getMoisture() + ",\"Field2\":" + readingIn.getTemperature() +  ",\"Field3\":" + readingIn.getDate()  
			+ ",\"api_keys\": [ { \"api_key\": \"" + ThingSpeakEnum.APIKey.getValue() + "\", \"write_flag\": true }]";
			connectSend(output);
//			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//			System.out.println("Output from Server .... \n");
//			while ((output = br.readLine()) != null) {
//				System.out.println(output);
//			}
//
//			conn.disconnect();
//
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();


	}

	public void connectSend(String output) throws IOException, InterruptedException{
		URL url = new URL("http://api.thingspeak.com/channels/143256/"+output);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		
		
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		dos.writeBytes(output);
		dos.flush();
		dos.close();
		conn.disconnect();
		
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + output);
		System.out.println("Response Code : " + responseCode);
		
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		conn.disconnect();
		
	}
	
}
