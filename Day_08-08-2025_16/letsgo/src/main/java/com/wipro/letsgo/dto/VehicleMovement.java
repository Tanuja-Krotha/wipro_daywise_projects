package com.wipro.letsgo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="vehicle_movement")
public class VehicleMovement {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	@Column(name="vehicle_id")
	    private int vehicleId;
	    @Column(name="latitude")
	 	private double latitude;
	    @Column(name = "longitude") 
	    private double longitude;

	    public VehicleMovement()
	    {
	    	super();
	    }

		public VehicleMovement(int id, int vehicleId, double latitude, double longitude) {
			super();
			this.id = id;
			this.vehicleId = vehicleId;
			this.latitude = latitude;
			this.longitude = longitude;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getVehicleId() {
			return vehicleId;
		}

		public void setVehicleId(int vehicleId) {
			this.vehicleId = vehicleId;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}

		@Override
		public String toString() {
			return "VehicleMovement [id=" + id + ", vehicleId=" + vehicleId + ", latitude=" + latitude + ", longitude="
					+ longitude + "]";
		}
	    
}
