package com.TransTech.LalResidency.service;

import java.util.List;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.entity.Renter;

public interface RenterService {
    Renter addRenter(Renter renter);
    List<Renter> getAllRenters();
    Renter getRenterById(Long renterId);
    Renter updateRenter(Long renterId, Renter renter);
    boolean deleteRenter(Long renterId);
    List<Flat> getRentersInFlat(Long flatId);

}
