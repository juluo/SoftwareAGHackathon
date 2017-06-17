package org.softwareag.hackthon.response;

import java.util.ArrayList;
import java.util.List;

import org.softwareag.hackthon.service.Route;

/**
 * Created by rvignesh on 6/17/2017.
 */
public class StartResponse {

    private String tripId;

    private int status;

    List<Route> routes = new ArrayList<>(); 
    		
    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}



}
