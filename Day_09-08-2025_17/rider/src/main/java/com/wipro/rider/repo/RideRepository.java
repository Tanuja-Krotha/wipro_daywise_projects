package com.wipro.rider.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.rider.model.RideRequest;

@Repository
public interface RideRepository  extends JpaRepository<RideRequest, Integer>{

}
