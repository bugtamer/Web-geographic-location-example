package com.github.bugtamer.geolocation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bugtamer.geolocation.models.GeoCoords;
import com.github.bugtamer.geolocation.models.NearbyLocations;
import com.github.bugtamer.geolocation.util.RandomGeolocation;


/**
 * @author https://github.com/bugtamer
 */
@WebServlet("/store-geolocation")
public class GeolocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GeoCoords origin = getGeoCoords(request);
		NearbyLocations nearbyLocations = generateNearbyLocations(origin);
		String json = parseToJson(nearbyLocations);
		
		response.setContentType("application/json");
		response.getWriter().append( json ).flush();
	}
	
	
	
	// LOWER LEVEL IMPLEMENTATION DETAILS
	
	private GeoCoords getGeoCoords(HttpServletRequest request) {
		String lat = request.getParameter("latitude");
		String lon = request.getParameter("longitude");
		String acc = request.getParameter("accuracy");
		String ts  = request.getParameter("timestamp");
		
		double latitude  = Double.parseDouble(lat);
		double longitude = Double.parseDouble(lon);
		int    accuracy  = Integer.parseInt(acc);
		long   timestamp = Long.parseLong(ts);
		
		GeoCoords coords = new GeoCoords();
		coords.setLatitude(latitude);
		coords.setLongitude(longitude);
		coords.setAccuracy(accuracy);
		coords.setTimestamp(timestamp);
		return coords;
	}
	
	
	private String parseToJson(NearbyLocations nearbyLocations) {
		String json = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(nearbyLocations);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	private NearbyLocations generateNearbyLocations(GeoCoords coords) {
		NearbyLocations nLocations = new NearbyLocations();
		nLocations.setOrigin(coords);
		for (int i = 0;   i < 3;   i++) {
			nLocations.add( RandomGeolocation.getNearTo(coords));
		}
		return nLocations;
	}

}
