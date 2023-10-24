package com.TransTech.LalResidency.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.entity.Property;
import com.TransTech.LalResidency.repository.PropertyRepository;
import com.TransTech.LalResidency.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    

	@Override
	public Property addProperty(Property property) {
		return propertyRepository.save(property);
	}

	@Override
	public Property updateProperty(Long propertyId, Property property) {
	    Optional<Property> existingPropertyOptional = propertyRepository.findById(propertyId);

	    if (existingPropertyOptional.isPresent()) {
	        Property existingProperty = existingPropertyOptional.get();
	        existingProperty.setName(property.getName());
	        existingProperty.setFlats(property.getFlats());
	        existingProperty.setAddress(property.getAddress());

	        return propertyRepository.save(existingProperty);
	    } else {
	        // Handle the case where the property with propertyId does not exist
	        return null;
	    }
	}


	@Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    

    @Override
    public Property findPropertyById(Long propertyId) {
        Optional<Property> optionalProperty = propertyRepository.findById(propertyId);
        return optionalProperty.orElse(null);
    }

    @Override      
    public boolean deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
		return true;
    }

    @Override
    public List<Flat> getFlatsInProperty(Long propertyId) {
        Property property = findPropertyById(propertyId);
        if (property != null) {
            return property.getFlats();
        }
        return null;
    }


}
