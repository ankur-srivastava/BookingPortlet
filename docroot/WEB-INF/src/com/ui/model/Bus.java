/**
 * 
 */
package com.ui.model;

/**
 * @author SRIVASTAVAA
 *
 */
public class Bus {

	/**
	 * 
	 */
	public Bus() {
		// TODO Auto-generated constructor stub
	}

	private long busId;
	private String busName;
	private String travelDate;
	private String travelTime;
	private long total;
	private long available;
	private long price;
	
	
	
	public Bus(long busId, String busName, String travelDate,
			String travelTime, long total, long available, long price) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.travelDate = travelDate;
		this.travelTime = travelTime;
		this.total = total;
		this.available = available;
		this.price = price;
	}
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getAvailable() {
		return available;
	}
	public void setAvailable(long available) {
		this.available = available;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
}
