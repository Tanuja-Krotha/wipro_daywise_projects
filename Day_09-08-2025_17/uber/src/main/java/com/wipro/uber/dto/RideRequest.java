package com.wipro.uber.dto;

public class RideRequest {
	
	int id;
	int rideId;
    String pickupLocation;
    String dropLocation;
    String riderName;
    String status;
    
    public RideRequest() {
		super();
	}

	public RideRequest(int id, int rideId, String pickupLocation, String dropLocation, String riderName,
			String status) {
		super();
		this.id = id;
		this.rideId = rideId;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.riderName = riderName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RideRequest [id=" + id + ", rideId=" + rideId + ", pickupLocation=" + pickupLocation + ", dropLocation="
				+ dropLocation + ", riderName=" + riderName + ", status=" + status + "]";
	} 
	
	
    
    

}
