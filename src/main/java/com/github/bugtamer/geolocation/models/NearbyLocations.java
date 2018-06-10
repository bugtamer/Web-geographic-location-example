package com.github.bugtamer.geolocation.models;

import java.util.ArrayList;
import java.util.List;

public class NearbyLocations {
	
	private GeoCoords origin;
	private List<GeoCoords> nearbyLocations;
	
	
	
	public NearbyLocations() {
		this.nearbyLocations = new ArrayList<>();
	}
	
	
	
	public GeoCoords getOrigin() {
		return origin;
	}
	
	
	public void setOrigin(GeoCoords origin) {
		this.origin = origin;
	}
	
	
	public List<GeoCoords> getNearbyLocations() {
		return this.nearbyLocations;
	}
	
	
	public void add(GeoCoords nearby) {
		this.nearbyLocations.add(nearby);
	}

}
