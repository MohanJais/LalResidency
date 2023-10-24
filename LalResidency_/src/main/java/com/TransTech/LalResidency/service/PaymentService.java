package com.TransTech.LalResidency.service;

import java.util.List;

import com.TransTech.LalResidency.entity.Payment;


public interface PaymentService {
	Payment recordPayment(Payment payment);
    boolean confirmPayment(Long paymentId);
    List<Payment> getPaymentsByRenter(Long renterId);
	Payment getPaymentById(Long paymentId);
	Payment updatePaymentDetails(Long paymentId, Payment updatedPayment);
    void generateReceipt(Long paymentId);
    void deletePayment(Long paymentId);
	List<Payment> getUnpaidPaymentsForProperty(Long propertyId);
}
