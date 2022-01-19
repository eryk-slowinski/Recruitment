package com.recruitment.task.models;

import java.util.Date;

public class TransactionsSummary {

    private String firstName;
    private String lastName;
    private Long customerId;
    private int numberOfTransactions;
    private float totalValueOfTransactions;
    private float transactionsFeeValue;
    private Date lastTransactionDate;

    public TransactionsSummary() {
    }

    public TransactionsSummary(String firstName, String lastName, Long customerId, int numberOfTransactions, float totalValueOfTransactions, float transactionsFeeValue, Date lastTransactionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.numberOfTransactions = numberOfTransactions;
        this.totalValueOfTransactions = totalValueOfTransactions;
        this.transactionsFeeValue = transactionsFeeValue;
        this.lastTransactionDate = lastTransactionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(int numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public float getTotalValueOfTransactions() {
        return totalValueOfTransactions;
    }

    public void setTotalValueOfTransactions(float totalValueOfTransactions) {
        this.totalValueOfTransactions = totalValueOfTransactions;
    }

    public float getTransactionsFeeValue() {
        return transactionsFeeValue;
    }

    public void setTransactionsFeeValue(float transactionsFeeValue) {
        this.transactionsFeeValue = transactionsFeeValue;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(Date lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }
}
