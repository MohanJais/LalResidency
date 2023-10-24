package com.TransTech.LalResidency.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.entity.Renter;
import com.TransTech.LalResidency.repository.FlatRepository;
import com.TransTech.LalResidency.repository.RenterRepository;
import com.TransTech.LalResidency.service.RenterService;

@Service
public class RenterServiceImpl implements RenterService {

    @Autowired
    private RenterRepository renterRepository;
    
    @Autowired
    private FlatRepository flatRepository;

    @Override
    public Renter addRenter(Renter renter) {
        return renterRepository.save(renter);
    }
    
    @Override
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

   
    @Override
    public Renter getRenterById(Long renterId) {
        return renterRepository.findById(renterId).orElse(null);
    }

    @Override
    public Renter updateRenter(Long renterId, Renter renter) {
    	Optional<Renter> existRenter = Optional.of(renterRepository.getById(renterId));
    	if(existRenter.isPresent()) {
    		Renter updatedRenter = existRenter.get();
    		updatedRenter.setName(renter.getName());
    		updatedRenter.setContactNumber(renter.getContactNumber());
    		updatedRenter.setFlat(renter.getFlat());
    		updatedRenter.setMoveInDate(renter.getMoveInDate());
    		updatedRenter.setMoveOutDate(renter.getMoveOutDate());
    		
    		return renterRepository.save(updatedRenter);      
    	}else {
    		return null;
    	}
    }

    @Override
    public boolean deleteRenter(Long renterId) {
        renterRepository.deleteById(renterId);
		return true;
    }
    
    @Override
    public List<Flat> getRentersInFlat(Long flatId) {
        // Implement logic to retrieve renters in a specific flat

    	return flatRepository.findAll();
    }

   
}
