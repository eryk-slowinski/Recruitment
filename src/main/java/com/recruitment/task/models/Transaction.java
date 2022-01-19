package com.recruitment.task.models;

import com.recruitment.task.utils.DataConverter;
import java.util.Date;

public class Transaction {

    private Long transactionId;
    private float transactionAmount;
    private String customerFirstName;
    private Long customerId;
    private String customerLastName;
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(Long transactionId, float transactionAmount, String customerFirstName, Long customerId, String customerLastName, Date transactionDate) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.customerFirstName = customerFirstName;
        this.customerId = customerId;
        this.customerLastName = customerLastName;
        this.transactionDate = transactionDate;
    }

    public Transaction(String[] transactionColumns) {
        this.transactionId = DataConverter.convertToLong(transactionColumns[0]);
        this.transactionAmount = DataConverter.convertToFloat(transactionColumns[1]);
        this.customerFirstName = transactionColumns[2];
        this.customerId = DataConverter.convertToLong(transactionColumns[3]);
        this.customerLastName = transactionColumns[4];
        this.transactionDate = DataConverter.convertToDate(transactionColumns[5]);
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transaction_amount) {
        this.transactionAmount = transaction_amount;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
