package com.TransTech.LalResidency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TransTech.LalResidency.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
	    List<Property> findByPropertyType(String propertyType);
	    Property findPropertyById(Long propertyId);
	    //List<Flat> getFlatsByProperty(Long propertyId);
}

