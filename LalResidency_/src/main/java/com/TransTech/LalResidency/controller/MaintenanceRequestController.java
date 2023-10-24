/*package com.TransTech.LalResidency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TransTech.LalResidency.entity.MaintenanceRequest;
import com.TransTech.LalResidency.service.MaintenanceRequestService;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceRequestController {

	@Autowired
	private MaintenanceRequestService maintenanceRequestService;
	
   
    @PostMapping
    public ResponseEntity<MaintenanceRequest> createRequest(@RequestBody MaintenanceRequest request) {
        MaintenanceRequest createdRequest = maintenanceRequestService.createMaintenanceRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    @PutMapping("/{requestId}/resolve")
    public ResponseEntity<Void> updateRequest(@PathVariable Long requestId) {
        boolean resolved = maintenanceRequestService.updateMaintenanceRequest(requestId);
        if (resolved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long requestId) {
        boolean deleted = maintenanceRequestService.deleteMaintenanceRequest(requestId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
    // Add more endpoints for maintenance request-related actions (e.g., list requests by renter, property)
   /*
    	
    	 @GetMapping("/{requestId}")
    	public ResponseEntity<MaintenanceRequest> getRequestById(@PathVariable Long requestId) {
        MaintenanceRequest request = maintenanceRequestService.getRequestById(requestId);
        if (request != null) {
            return new ResponseEntity<>(request, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        @GetMapping("/{renterId}/requests")
        public ResponseEntity<List<MaintenanceRequest>> getMaintenanceRequestsByRenter(@PathVariable Long renterId) {
            List<MaintenanceRequest> requests = maintenanceRequestService.getMaintenanceRequestsByRenter(renterId);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        }

        @GetMapping("/{propertyId}/requests")
        public ResponseEntity<List<MaintenanceRequest>> getMaintenanceRequestsByProperty(@PathVariable Long propertyId) {
            List<MaintenanceRequest> requests = maintenanceRequestService.getMaintenanceRequestsByProperty(propertyId);
            return new ResponseEntity<>(requests, HttpStatus.OK);
        }

        @GetMapping("/{propertyId}/open-requests")
        public ResponseEntity<List<MaintenanceRequest>> getOpenMaintenanceRequestsByProperty(@PathVariable Long propertyId) {
            List<MaintenanceRequest> openRequests = maintenanceRequestService.getOpenMaintenanceRequestsByProperty(propertyId);
            return new ResponseEntity<>(openRequests, HttpStatus.OK);
        }

        @PutMapping("/{requestId}/assign")
        public ResponseEntity<Void> assignMaintenanceRequest(@PathVariable Long requestId, @RequestBody Employee assignedEmployee) {
            boolean assigned = maintenanceRequestService.assignMaintenanceRequest(requestId, assignedEmployee);
            if (assigned) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
	*/
        // Add more endpoints for maintenance request-related actions (e.g., mark request as completed, update request details)
    

