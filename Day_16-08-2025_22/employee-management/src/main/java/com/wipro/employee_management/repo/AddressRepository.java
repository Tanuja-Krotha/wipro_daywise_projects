package com.wipro.employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.employee_management.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
