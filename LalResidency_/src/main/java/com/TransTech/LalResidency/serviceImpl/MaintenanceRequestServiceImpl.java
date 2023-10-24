
//package com.TransTech.LalResidency.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.TransTech.LalResidency.entity.MaintenanceRequest;
//import com.TransTech.LalResidency.repository.MaintenanceRequestRepository;
//import com.TransTech.LalResidency.service.MaintenanceRequestService;
//
//@Service
//public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
//
//    @Autowired
//    private MaintenanceRequestRepository maintenanceRequestRepository;
//
//    @Override
//    public List<MaintenanceRequest> getAllMaintenanceRequests() {
//        return maintenanceRequestRepository.findAll();
//    }
//
//    @Override
//    public List<MaintenanceRequest> getMaintenanceRequestsByRenter(Long renterId) {
//        // Example: Retrieve maintenance requests for a specific renter
//        // Replace this with your own logic to filter by renter
//        return maintenanceRequestRepository.findByRenterId(renterId);
//    }
//
//    @Override
//    public List<MaintenanceRequest> getMaintenanceRequestsByProperty(Long propertyId) {
//        // Example: Retrieve maintenance requests for a specific property
//        // Replace this with your own logic to filter by property
//        return maintenanceRequestRepository.findByPropertyId(propertyId);
//    }
//
//   
//    
//    @Override
//    public MaintenanceRequest createMaintenanceRequest(MaintenanceRequest request) {
//        return maintenanceRequestRepository.save(request);
//    }
//
//    @Override
//    public boolean updateMaintenanceRequest(Long requestId) {
//    	maintenanceRequestRepository.getById(requestId);
//		return ture;
//    }
//
//    @Override
//    public boolean deleteMaintenanceRequest(Long requestId) {
//        maintenanceRequestRepository.deleteById(requestId);
//		return true;
//    }
//}
