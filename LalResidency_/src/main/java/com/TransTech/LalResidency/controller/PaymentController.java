package com.TransTech.LalResidency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TransTech.LalResidency.entity.Payment;
import com.TransTech.LalResidency.entity.Receipt;
import com.TransTech.LalResidency.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
    
    @PostMapping
    public ResponseEntity<Payment> recordPayment(@RequestBody Payment payment) {
        Payment recordedPayment = paymentService.recordPayment(payment);
        return new ResponseEntity<>(recordedPayment, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}/confirm")
    public ResponseEntity<Void> confirmPayment(@PathVariable Long paymentId) {
        boolean confirmed = paymentService.confirmPayment(paymentId);
        if (confirmed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{renterId}/payments")
    public ResponseEntity<List<Payment>> getPaymentsForRenter(@PathVariable Long renterId) {
        List<Payment> payments = paymentService.getPaymentsByRenter(renterId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }
    
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<Payment> updatePaymentDetails(@PathVariable Long paymentId, @RequestBody Payment updatedPayment) {
        Payment updated = paymentService.updatePaymentDetails(paymentId, updatedPayment);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Add more endpoints for payment-related actions (e.g., generate receipts, view payment history)
    
        @GetMapping("/{propertyId}/payments")
        public ResponseEntity<List<Payment>> getPaymentsForProperty(@PathVariable Long propertyId) {
            List<Payment> payments = paymentService.getUnpaidPaymentsForProperty(propertyId);
            return new ResponseEntity<>(payments, HttpStatus.OK);
        }
        
        /* 
        @GetMapping("/{propertyId}/unpaid-payments")
        public ResponseEntity<List<Payment>> getUnpaidPaymentsForProperty(@PathVariable Long propertyId) {
            List<Payment> unpaidPayments = paymentService.getUnpaidPaymentsForProperty(propertyId);
            return new ResponseEntity<>(unpaidPayments, HttpStatus.OK);
        }

        // Add more endpoints for payment-related actions (e.g., update payment details, calculate late fees)
       

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
        
        */

            @GetMapping("/{paymentId}/receipt")
            public ResponseEntity<Receipt> generateReceipt(@PathVariable Long paymentId) {
                // Retrieve the payment by ID
                Payment payment = paymentService.getPaymentById(paymentId);

                if (payment == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

                // Generate a receipt based on the payment details
                Receipt receipt = generateReceiptFromPayment(payment);

                if (receipt != null) {
                    return new ResponseEntity<>(receipt, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }

            // Helper method to generate a receipt from a payment
            private Receipt generateReceiptFromPayment(Payment payment) {
                // Implement logic to generate the receipt from payment details
                // You can format the receipt as a PDF, HTML, or any other desired format
                // You might include payment details, property information, and other relevant data
                Receipt receipt = new Receipt();
                receipt.setPaymentId(payment.getId());
                receipt.setAmount(payment.getAmount());
                receipt.setPaymentDate(payment.getPaymentDate());
                // Add more receipt details as needed

                // Return the generated receipt
                return receipt;
            }

            // Add more endpoints for payment-related actions (e.g., update payment details, calculate late fees)
        

}
