package org.softwareag.hackthon.service;

import java.util.LinkedList;

public class Route {

	private long id;
	
	private String primaryUser;
	
	private String secondaryUser;
	
	private Location start;
	
	private Location end;
	
	private LinkedList<Location> routeMap = new LinkedList<>();
	
	private double price;
	
	private long time;
	
	private long prinaryStartIn = 0;
	
	private long secondaryStartIn = 0;
	
	private double primaryPrice;
	
	private double secondaryPrice;
	
	private int primaryTime;
	
	private int secondaryTime;	
	
	private String mapUrl;


	public String getPrimaryUser() {
		return primaryUser;
	}

	public void setPrimaryUser(String primaryUser) {
		this.primaryUser = primaryUser;
	}

	public String getSecondaryUser() {
		return secondaryUser;
	}

	public void setSecondaryUser(String secondaryUser) {
		this.secondaryUser = secondaryUser;
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

	public double getPrimaryPrice() {
		return primaryPrice;
	}

	public void setPrimaryPrice(double primaryPrice) {
		this.primaryPrice = primaryPrice;
	}

	public double getSecondaryPrice() {
		return secondaryPrice;
	}

	public void setSecondaryPrice(double secondaryPrice) {
		this.secondaryPrice = secondaryPrice;
	}

	public int getPrimaryTime() {
		return primaryTime;
	}

	public void setPrimaryTime(int primaryTime) {
		this.primaryTime = primaryTime;
	}

	public int getSecondaryTime() {
		return secondaryTime;
	}

	public void setSecondaryTime(int secondaryTime) {
		this.secondaryTime = secondaryTime;
	}

	public long getPrinaryStartIn() {
		return prinaryStartIn;
	}

	public void setPrinaryStartIn(long prinaryStartIn) {
		this.prinaryStartIn = prinaryStartIn;
	}

	public long getSecondaryStartIn() {
		return secondaryStartIn;
	}

	public void setSecondaryStartIn(long secondaryStartIn) {
		this.secondaryStartIn = secondaryStartIn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	
}
