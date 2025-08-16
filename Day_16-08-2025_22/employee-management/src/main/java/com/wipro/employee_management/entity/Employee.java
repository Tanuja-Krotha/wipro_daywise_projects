package com.wipro.employee_management.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	@Column(name="name")
	    private String name;
	 	@Column(name="type")
	 	private String type; // Contract or Regular
	 	@Column(name="email")
	 	private String email;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	    private Address address;

	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;

		public Employee() {
			super();
		}

		public Employee(Long id, String name, String type, String email, Address address, Department department) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.email = email;
			this.address = address;
			this.department = department;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", type=" + type + ", email=" + email + ", address="
					+ address + ", department=" + department + "]";
		}
	    
	    

}
