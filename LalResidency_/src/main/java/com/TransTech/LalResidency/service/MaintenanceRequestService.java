package com.TransTech.LalResidency.service;

import java.util.List;

import com.TransTech.LalResidency.entity.MaintenanceRequest;

public interface MaintenanceRequestService {

    MaintenanceRequest createMaintenanceRequest(MaintenanceRequest request);
    boolean resolveMaintenanceRequest(Long requestId);
    boolean deleteMaintenanceRequest(Long requestId);
//	List<MaintenanceRequest> getAllMaintenanceRequests();
//	List<MaintenanceRequest> getMaintenanceRequestsByRenter(Long renterId);
//	List<MaintenanceRequest> getMaintenanceRequestsByProperty(Long propertyId);
//  List<MaintenanceRequest> getOpenMaintenanceRequestsByProperty(Long propertyId);
}
