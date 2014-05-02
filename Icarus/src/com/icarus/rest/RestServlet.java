package com.icarus.rest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

public class RestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doBoth(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doBoth(request, response);
	}
	public void doBoth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestUrl = request.getRequestURL().toString();
		String jsonResponse = "{status:400}";
		if(requestUrl.endsWith("updateLocation.api"))
		{
			String phoneNumber = request.getParameter("phoneNumber");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			if(phoneNumber!=null && latitude!=null && longitude!=null)
			{
				ApplicationControl control = new ApplicationControlImpl();
				jsonResponse = control.updateLocationRest(phoneNumber, latitude, longitude);
			}
		}else if(requestUrl.endsWith("getNearestMedicalEmergencyUnits.api"))
		{
			String phoneNumber = request.getParameter("phoneNumber");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");
			if(phoneNumber!=null && latitude!=null && longitude!=null)
			{
				ApplicationControl control = new ApplicationControlImpl();
				jsonResponse = control.getNearestUsersRest(phoneNumber, latitude, longitude, (long)1);
			}
		}
		else if(requestUrl.endsWith("checkConnection.api"))
		{
			jsonResponse = "{status:200}";
			System.out.println("Remote application verified connection.");
			/*response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(jsonResponse);
			out.flush();*/
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println("recieve("+jsonResponse+")");
	}
}
