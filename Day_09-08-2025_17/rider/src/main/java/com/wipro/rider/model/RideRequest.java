package com.wipro.rider.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="riderequest")
public class RideRequest {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 int id;
	 @Column(name="ride_id")
	 int rideId;
     @Column(name="pickup_location")
	 String pickupLocation;
     @Column(name="drop_location")
     String dropLocation;
     @Column(name="rider_name")
     String riderName;
     @Column(name="status")
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
