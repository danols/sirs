package sirs.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import sirs.model.*;
import sirs.dao.*;

public class MainController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/view/";
		String url = base + "index.jsp";
	    String action = request.getParameter("action");
	    if(action != null) { 
	    	switch(action) {
	    		case "consultDrivers":
	    			consultDrivers(request,response);
	    			url = base + "consultDrivers.jsp";
	    		break;
	    	}
	    }
	    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
	    requestDispatcher.forward(request, response);
	}
	private void consultDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DriverDAO driverDAO = new DriverDAO();
			List<Driver> drivers = driverDAO.getAllDrivers();
			request.setAttribute("drivers", drivers);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}