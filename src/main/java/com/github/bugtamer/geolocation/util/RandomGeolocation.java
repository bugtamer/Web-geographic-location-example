package com.github.bugtamer.geolocation.util;

import java.util.Random;

import com.github.bugtamer.geolocation.models.GeoCoords;


public class RandomGeolocation {
	
	static Random rnd = new Random();
	
	
	private RandomGeolocation() { }
	
	
	
	public static GeoCoords getNearTo(GeoCoords geoCoords) {
		GeoCoords nearBy = new GeoCoords();
		nearBy.setLatitude(  geoCoords.getLatitude()  + getOffset() );
		nearBy.setLongitude( geoCoords.getLongitude() + getOffset() );
		nearBy.setAccuracy(  geoCoords.getAccuracy() );
		nearBy.setTimestamp( geoCoords.getTimestamp() );
		return nearBy;
	}
	
	
	
	private static double getOffset() {
		return getSign() * ((double) rnd.nextInt(125)) / 100_000;
	}
	
	
	
	private static int getSign() {
		return rnd.nextBoolean() ? 1 : -1;
	}

}
