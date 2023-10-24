package com.TransTech.LalResidency.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String propertyType; 
    @OneToMany(mappedBy = "property")
    private List<Flat> flats;

	public Property() {
		
	}

	public Property(Long id, String name, String address, String propertyType, List<Flat> flats) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.propertyType = propertyType;
		this.flats = flats;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", address=" + address + ", propertyType=" + propertyType
				+ ", flats=" + flats + "]";
	}

	
    
}
