package com.github.bugtamer.geolocation.models;


/**
 * @author https://github.com/bugtamer
 */
public class GeoCoords {
	
	private double latitude;
	private double longitude;
	private int    accuracy;
	private long   timestamp;
	
	
	
	// GETTERS
	
	public double getLatitude() {
		return latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public int getAccuracy() {
		return accuracy;
	}


	public long getTimestamp() {
		return timestamp;
	}
	
	
	
	// SETTERS
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	// OVERRIDED METHODS
	
	@Override
	public String toString() {
		return String.format("{Lat=%.3f, Lon=%.3f, accu=%d, ts=%d}", latitude, longitude, accuracy, timestamp);
	}

}
