package com.TransTech.LalResidency.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TransTech.LalResidency.entity.Payment;
import com.TransTech.LalResidency.repository.PaymentRepository;
import com.TransTech.LalResidency.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    
    @Override
    public Payment recordPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public boolean confirmPayment(Long paymentId) {
        // Implement logic to confirm the payment
    	return true;
    }
    
    @Override
    public List<Payment> getPaymentsByRenter(Long renterId) {
    	return paymentRepository.findAll();
    }

    @Override
	public Payment getPaymentById(Long paymentId) {
		// TODO Auto-generated method stub
		return paymentRepository.getById(paymentId);
	}
    
    @Override
    public Payment updatePaymentDetails(Long paymentId, Payment updatedPayment) {
        // Retrieve the existing payment from the database
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(paymentId);

        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();

            // Update the payment details with the values from the updatedPayment object
            existingPayment.setAmount(updatedPayment.getAmount());
            existingPayment.setPaymentDate(updatedPayment.getPaymentDate());
            existingPayment.setPaymentMethod(updatedPayment.getPaymentMethod());

            // Save the updated payment to the database
            Payment updated = paymentRepository.save(existingPayment);

            return updated;
        } else {
            // Handle the case where the payment with paymentId does not exist
            return null;
        }
    }

	
    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public void generateReceipt(Long paymentId) {
        // Implement logic to generate a payment receipt
    }

    	
	
	@Override
	public List<Payment> getUnpaidPaymentsForProperty(Long propertyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
