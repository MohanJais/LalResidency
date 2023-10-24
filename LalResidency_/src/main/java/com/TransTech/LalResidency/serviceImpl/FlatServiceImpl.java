package com.TransTech.LalResidency.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.repository.FlatRepository;
import com.TransTech.LalResidency.service.FlatService;

@Service
public class FlatServiceImpl implements FlatService {

    @Autowired
    private FlatRepository flatRepository;

    @Override
	public Flat addFlat(Flat flat) {
		// TODO Auto-generated method stub
		return flatRepository.save(flat);
	}

	@Override
	public List<Flat> getAllFlats() {
		// TODO Auto-generated method stub
		return flatRepository.findAll();
	}

	@Override
	public List<Flat> getFlatsByProperty(Long propertyId) {
		// TODO Auto-generated method stub
		return flatRepository.findFlatsByPropertyId(propertyId);
	}

	@Override
	public Flat getFlatById(Long flatId) {
		// TODO Auto-generated method stub
		return flatRepository.getById(flatId);
	}

	
	@Override
	public Flat updateFlat(Long flatId, Flat flat) {
		// TODO Auto-generated method stub
		//Flat existFlat = flatRepository.getById(flatId);
		Optional<Flat> existFlat =Optional.of(flatRepository.getById(flatId));
		if(existFlat.isPresent()) {
		Flat updatedFlat = existFlat.get();
		updatedFlat.setNumber(flat.getNumber());
		updatedFlat.setProperty(flat.getProperty());
		updatedFlat.setRent(flat.getRent());
		
		return flatRepository.save(updatedFlat);
		}else {
		return null;
		}
	}
	
	@Override
	public boolean deleteFlat(Long flatId) {
		// TODO Auto-generated method stub
		Optional<Flat> existFlat =Optional.of(flatRepository.getById(flatId));
		if(existFlat.isPresent()) {
			flatRepository.deleteById(flatId);
		return true;
		}else {
		return false;
			}
	}
}
  /*  @Override
    public List<Flat> getAllFlats() {
        return flatRepository.findAll();
    }

    @Override
    public List<Flat> getFlatsByProperty(Long propertyId) {
        return flatRepository.findByPropertyId(propertyId);
    }

    @Override
    public Flat getFlatById(Long flatId) {
        return flatRepository.findById(flatId).orElse(null);
    }

    @Override
    public void addFlat(Flat flat) {
        flatRepository.save(flat);
    }

    @Override
    public void updateFlat(Flat flat) {
        flatRepository.save(flat);
    }

    @Override
    public void deleteFlat(Long flatId) {
        flatRepository.deleteById(flatId);
    }

	@Override
	public void updateFlat(Long flatId, Flat flat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteFlat(Long flatId) {
		// TODO Auto-generated method stub
		return false;
	}
	*/

