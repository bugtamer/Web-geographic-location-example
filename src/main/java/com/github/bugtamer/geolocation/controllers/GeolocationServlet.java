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


/**
 * @author https://github.com/bugtamer
 */
@WebServlet("/store-geolocation")
public class GeolocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GeoCoords coords = getGeoCoords(request);
		String    json   = parseToJson(coords);
		
		response.setContentType("application/json");
		response.getWriter().append( json ).flush();
	}
	
	
	
	// LOWER LEVEL IMPLEMENTATION DETAILS
	
	private GeoCoords getGeoCoords(HttpServletRequest request) {
		GeoCoords coords = new GeoCoords();
		
		String lat = request.getParameter("latitude");
		String lon = request.getParameter("longitude");
		String acc = request.getParameter("accuracy");
		String ts  = request.getParameter("timestamp");
		
		double latitude  = Double.parseDouble(lat);
		double longitude = Double.parseDouble(lon);
		int    accuracy  = Integer.parseInt(acc);
		long   timestamp = Long.parseLong(ts);
		
		coords.setLatitude(latitude);
		coords.setLongitude(longitude);
		coords.setAccuracy(accuracy);
		coords.setTimestamp(timestamp);
		
		System.out.println("GeolocationServlet - Coords=\t" + coords);
		
		return coords;
	}
	
	
	private String parseToJson(GeoCoords coords) {
		String json = "{}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(coords);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("GeolocationServlet - JSON=\t" + json);
		
		return json;
	}

}
