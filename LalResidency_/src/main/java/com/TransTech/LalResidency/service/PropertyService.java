package com.TransTech.LalResidency.service;

import java.util.List;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.entity.Property;

public interface PropertyService {
    Property addProperty(Property property);
	List<Property> getAllProperties();
    Property findPropertyById(Long propertyId);
    Property updateProperty(Long propertyId, Property property);
    boolean deleteProperty(Long propertyId);
    List<Flat> getFlatsInProperty(Long propertyId);
	//Property getPropertyById(Long propertyId);

}
