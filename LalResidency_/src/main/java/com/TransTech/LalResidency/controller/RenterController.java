package com.TransTech.LalResidency.controller;

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

import com.TransTech.LalResidency.entity.Renter;
import com.TransTech.LalResidency.service.PaymentService;
import com.TransTech.LalResidency.service.RenterService;

@RestController
@RequestMapping("/api")
public class RenterController {

    @Autowired
    private RenterService renterService;
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/createRenter")
    public ResponseEntity<Renter> createRenter(@RequestBody Renter renter) {
        Renter createdRenter = renterService.addRenter(renter);
        return new ResponseEntity<>(createdRenter, HttpStatus.CREATED);
    }
    
    @GetMapping("/renters")
    public ResponseEntity<List<Renter>> getAllRenter() {
        	return new ResponseEntity<>(renterService.getAllRenters(),HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{renterId}")
    public ResponseEntity<Renter> getRenterById(@PathVariable Long renterId) {
        Renter renter = renterService.getRenterById(renterId);
        if (renter != null) {
            return new ResponseEntity<>(renter, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
  

    @PutMapping("/updateRenter/{renterId}")
    public ResponseEntity<Renter> updateRenter(@PathVariable Long renterId, @RequestBody Renter renter) {
        Renter updatedRenter = renterService.updateRenter(renterId, renter);
        if (updatedRenter != null) {
            return new ResponseEntity<>(updatedRenter, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{renterId}")
    public ResponseEntity<Void> deleteRenter(@PathVariable Long renterId) {
        boolean deleted = renterService.deleteRenter(renterId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    @GetMapping("/{renterId}/payments")
    public ResponseEntity<List<Payment>> getPaymentsForRenter(@PathVariable Long renterId) {
        List<Payment> payments = paymentService.getPaymentsByRenter(renterId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
    
    @GetMapping("/{renterId}/payment-history")
    public ResponseEntity<List<Payment>> getPaymentHistoryForRenter(@PathVariable Long renterId) {
        List<Payment> paymentHistory = paymentService.getPaymentHistoryForRenter(renterId);
        return new ResponseEntity<>(paymentHistory, HttpStatus.OK);
    }
    
    // Add more endpoints for renter-related actions
    @GetMapping("/{renterId}/properties")
    public ResponseEntity<List<Property>> getPropertiesForRenter(@PathVariable Long renterId) {
        List<Property> properties = propertyService.getPropertiesForRenter(renterId);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

   
    @PostMapping("/{renterId}/make-payment")
    public ResponseEntity<Payment> makePayment(@PathVariable Long renterId, @RequestBody Payment payment) {
        Payment madePayment = paymentService.makePaymentForRenter(renterId, payment);
        return new ResponseEntity<>(madePayment, HttpStatus.CREATED);
    }

    // Add more endpoints for renter-related actions (e.g., update renter profile, view lease agreement)
    @GetMapping("/{paymentId}/receipt")
    public ResponseEntity<Receipt> generateReceipt(@PathVariable Long paymentId) {
        Receipt receipt = paymentService.generateReceipt(paymentId);
        if (receipt != null) {
            return new ResponseEntity<>(receipt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{renterId}/payment-history")
    public ResponseEntity<List<Payment>> getPaymentHistoryForRenter(@PathVariable Long renterId) {
        List<Payment> paymentHistory = paymentService.getPaymentHistoryForRenter(renterId);
        return new ResponseEntity<>(paymentHistory, HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/payments")
    public ResponseEntity<List<Payment>> getPaymentsForProperty(@PathVariable Long propertyId) {
        List<Payment> payments = paymentService.getPaymentsForProperty(propertyId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{propertyId}/unpaid-payments")
    public ResponseEntity<List<Payment>> getUnpaidPaymentsForProperty(@PathVariable Long propertyId) {
        List<Payment> unpaidPayments = paymentService.getUnpaidPaymentsForProperty(propertyId);
        return new ResponseEntity<>(unpaidPayments, HttpStatus.OK);
    }
    
    

    @GetMapping("/{renterId}/maintenance-requests")
    public ResponseEntity<List<MaintenanceRequest>> getMaintenanceRequestsForRenter(@PathVariable Long renterId) {
        List<MaintenanceRequest> requests = maintenanceRequestService.getMaintenanceRequestsForRenter(renterId);
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping("/{renterId}/maintenance-request")
    public ResponseEntity<MaintenanceRequest> requestMaintenance(@PathVariable Long renterId, @RequestBody MaintenanceRequest request) {
        MaintenanceRequest createdRequest = maintenanceRequestService.createRequestForRenter(renterId, request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }
    
    @PutMapping("/{renterId}")
    public ResponseEntity<Renter> updateRenterProfile(@PathVariable Long renterId, @RequestBody Renter updatedRenter) {
        Renter updated = renterService.updateRenterProfile(renterId, updatedRenter);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{renterId}/lease-agreement")
    public ResponseEntity<LeaseAgreement> viewLeaseAgreement(@PathVariable Long renterId) {
        LeaseAgreement leaseAgreement = renterService.getLeaseAgreementForRenter(renterId);
        if (leaseAgreement != null) {
            return new ResponseEntity<>(leaseAgreement, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	*/
}
