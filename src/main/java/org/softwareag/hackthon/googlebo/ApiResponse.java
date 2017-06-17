package org.softwareag.hackthon.googlebo;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	@Column(name="destination_addresses")
	private List<String> destinations;
	
	@Column(name="origin_addresses")
	private List<String> orging;
	
	@Column(name="rows")
	private List<Row> rows;

	public List<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}

	public List<String> getOrging() {
		return orging;
	}

	public void setOrging(List<String> orging) {
		this.orging = orging;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "ApiResponse [destinations=" + destinations + ", orging=" + orging + ", rows=" + rows + "]";
	}
	
	
}
