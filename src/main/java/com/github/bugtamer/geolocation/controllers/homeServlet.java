package com.github.bugtamer.geolocation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.bugtamer.geolocation.util.GoogleMapConfig;


/**
 * @author https://github.com/bugtamer
 */
@WebServlet({
	"/home",
	"/index.html"})
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String googleApiKey = GoogleMapConfig.getInstance().getProperty("googleApiKey");
		request.setAttribute("googleApiKey", googleApiKey);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
