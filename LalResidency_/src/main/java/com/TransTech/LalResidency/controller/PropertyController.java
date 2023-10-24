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

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.entity.Property;
import com.TransTech.LalResidency.service.FlatService;
import com.TransTech.LalResidency.service.PaymentService;
import com.TransTech.LalResidency.service.PropertyService;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    
    @Autowired
    private FlatService flatService;
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/createProperty")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property createdProperty = propertyService.addProperty(property);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }
    
    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAllProperties() {
          return new ResponseEntity<>(propertyService.getAllProperties(),HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/{propertyId}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long propertyId) {
        Property property = propertyService.findPropertyById(propertyId);
        if (property != null) {
            return new ResponseEntity<>(property, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateProperty/{propertyId}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long propertyId, @RequestBody Property property) {
        Property updatedProperty = propertyService.updateProperty(propertyId, property);
        if (updatedProperty != null) {
            return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
        boolean deleted = propertyService.deleteProperty(propertyId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{propertyId}/flats")
    public ResponseEntity<List<Flat>> getFlatsInProperty(@PathVariable Long propertyId) {
        List<Flat> flats = flatService.getFlatsByProperty(propertyId);
        return new ResponseEntity<>(flats, HttpStatus.OK);
    }

    // Add more endpoints for property-related actions
   /*
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

        // Add more endpoints for payment-related actions (e.g., update payment details, calculate late fees)
    
	*/
}
