package com.TransTech.LalResidency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TransTech.LalResidency.entity.MaintenanceRequest;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long> {
	 List<MaintenanceRequest> findByRenterId(Long renterId);
	 List<MaintenanceRequest> findByPropertyId(Long propertyId);
}

