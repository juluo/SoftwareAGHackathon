package org.softwareag.hackthon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "share_details")
public class ShareDetails {

	@Id
	@GeneratedValue
	private int id;

	private String userId;

	private double startLat;

	private double startLong;

	private double stopLat;

	private double stopLong;

	private long duration;

	private double price;
	
	private boolean inActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public double getStartLat() {
		return startLat;
	}

	public void setStartLat(double startLat) {
		this.startLat = startLat;
	}

	public double getStartLong() {
		return startLong;
	}

	public void setStartLong(double startLong) {
		this.startLong = startLong;
	}

	public double getStopLat() {
		return stopLat;
	}

	public void setStopLat(double stopLat) {
		this.stopLat = stopLat;
	}

	public double getStopLong() {
		return stopLong;
	}

	public void setStopLong(double stopLong) {
		this.stopLong = stopLong;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInActive() {
		return inActive;
	}

	public void setInActive(boolean inActive) {
		this.inActive = inActive;
	}

	@Override
	public String toString() {
		return "ShareDetails [id=" + id + ", userId=" + userId + ", startLat=" + startLat + ", startLong=" + startLong
				+ ", stopLat=" + stopLat + ", stopLong=" + stopLong + ", duration=" + duration + ", price=" + price
				+ ", inActive=" + inActive + "]";
	}

}
