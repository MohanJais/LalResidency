package com.TransTech.LalResidency.service;

import java.util.List;

import com.TransTech.LalResidency.entity.Flat;

public interface FlatService {
    
	Flat addFlat(Flat flat);
	List<Flat> getAllFlats();
    List<Flat> getFlatsByProperty(Long propertyId);
    Flat getFlatById(Long flatId);
    Flat updateFlat(Long flatId, Flat flat);
    boolean deleteFlat(Long flatId);
    
}
