package org.softwareag.hackthon.response;

import java.util.ArrayList;
import java.util.List;

import org.softwareag.hackthon.entity.SuggestedRouteDetails;
import org.softwareag.hackthon.service.Route;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by rvignesh on 6/17/2017.
 */
@JsonInclude(Include.NON_NULL)
public class StartResponse {

	private String tripId;

	private int status;

	List<Route> routes = new ArrayList<>();

	List<SuggestedRouteDetails> routeList = new ArrayList<>();

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

	public List<SuggestedRouteDetails> getRouteList() {
		return routeList;
	}

	public void setRouteList(List<SuggestedRouteDetails> routeList) {
		this.routeList = routeList;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "StartResponse [tripId=" + tripId + ", status=" + status + ", routes=" + routes + ", routeList="
				+ routeList + "]";
	}

}
