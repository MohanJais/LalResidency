package com.TransTech.LalResidency.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Receipt {
    private Long paymentId;
    private BigDecimal amount;
    private Date paymentDate;
    private String propertyAddress;
    private String renterName;
    // Add more fields as needed

    public Receipt() {
        // Default constructor
    }

    public Receipt(Long paymentId, BigDecimal amount, Date paymentDate, String propertyAddress, String renterName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.propertyAddress = propertyAddress;
        this.renterName = renterName;
        // Initialize other fields as needed
    }

    // Getters and setters for the fields

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
    
    // Add getters and setters for other fields as needed

    @Override
    public String toString() {
        // Customize the formatting of the receipt as needed
        return "Receipt {" +
               "Payment ID: " + paymentId +
               ", Amount: " + amount +
               ", Payment Date: " + paymentDate +
               ", Property Address: " + propertyAddress +
               ", Renter Name: " + renterName +
               // Add other fields to the string representation
               '}';
    }
}
