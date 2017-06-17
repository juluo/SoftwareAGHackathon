package org.softwareag.hackthon.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suggested_route_details")
public class SuggestedRouteDetails {

	private long id;

	private String primaryUser;

	private String secondaryUser;

	private double combinedStart;

	private double combinedEnd;

	private double price;

	private long time;

	private double point1;

	private double point2;

	private double point3;

	private double point4;

	private long primaryStartIn = 0;

	private long secondaryStartIn = 0;

	private double primaryPrice;

	private double secondaryPrice;

	private int primaryTime;

	private int secondaryTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public double getCombinedStart() {
		return combinedStart;
	}

	public void setCombinedStart(double combinedStart) {
		this.combinedStart = combinedStart;
	}

	public double getCombinedEnd() {
		return combinedEnd;
	}

	public void setCombinedEnd(double combinedEnd) {
		this.combinedEnd = combinedEnd;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getPoint1() {
		return point1;
	}

	public void setPoint1(double point1) {
		this.point1 = point1;
	}

	public double getPoint2() {
		return point2;
	}

	public void setPoint2(double point2) {
		this.point2 = point2;
	}

	public double getPoint3() {
		return point3;
	}

	public void setPoint3(double point3) {
		this.point3 = point3;
	}

	public double getPoint4() {
		return point4;
	}

	public void setPoint4(double point4) {
		this.point4 = point4;
	}

	public long getPrimaryStartIn() {
		return primaryStartIn;
	}

	public void setPrimaryStartIn(long primaryStartIn) {
		this.primaryStartIn = primaryStartIn;
	}

	public long getSecondaryStartIn() {
		return secondaryStartIn;
	}

	public void setSecondaryStartIn(long secondaryStartIn) {
		this.secondaryStartIn = secondaryStartIn;
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

	@Override
	public String toString() {
		return "SuggestedRouteDetails [id=" + id + ", primaryUser=" + primaryUser + ", secondaryUser=" + secondaryUser
				+ ", combinedStart=" + combinedStart + ", combinedEnd=" + combinedEnd + ", price=" + price + ", time="
				+ time + ", point1=" + point1 + ", point2=" + point2 + ", point3=" + point3 + ", point4=" + point4
				+ ", primaryStartIn=" + primaryStartIn + ", secondaryStartIn=" + secondaryStartIn + ", primaryPrice="
				+ primaryPrice + ", secondaryPrice=" + secondaryPrice + ", primaryTime=" + primaryTime
				+ ", secondaryTime=" + secondaryTime + "]";
	}

}
