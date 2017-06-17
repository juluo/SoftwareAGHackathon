package org.softwareag.hackthon.service;

import java.util.LinkedList;

public class Route {

	private String startUser;
	
	private String endUser;
	
	private Location start;
	
	private Location end;
	
	private double price;
	
	private long time;
	
	private long startIn = 0;
	
	private double usrPrice;
	
	private double usrTime;
	
	private LinkedList<Location> routeMap = new LinkedList<>();

	public String getStartUser() {
		return startUser;
	}

	public void setStartUser(String startUser) {
		this.startUser = startUser;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public Location getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	public Location getEnd() {
		return end;
	}

	public void setEnd(Location end) {
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LinkedList<Location> getRouteMap() {
		return routeMap;
	}

	public void setRouteMap(LinkedList<Location> routeMap) {
		this.routeMap = routeMap;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getStartIn() {
		return startIn;
	}

	public void setStartIn(long startIn) {
		this.startIn = startIn;
	}

	public double getUsrPrice() {
		return usrPrice;
	}

	public void setUsrPrice(double usrPrice) {
		this.usrPrice = usrPrice;
	}

	public double getUsrTime() {
		return usrTime;
	}

	public void setUsrTime(double usrTime) {
		this.usrTime = usrTime;
	}
	
	
}
