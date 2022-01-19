package com.recruitment.task.models;

import com.recruitment.task.utils.DataConverter;

public class FeeWage {

    private Long transactionValueLessThan;
    private float feePercentageOfTransactionValue;

    public FeeWage() {
    }

    public FeeWage(Long transactionValueLessThan, float feePercentageOfTransactionValue) {
        this.transactionValueLessThan = transactionValueLessThan;
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }

    public FeeWage(String[] feeWagesColumns) {
        this.transactionValueLessThan = DataConverter.convertToLong(feeWagesColumns[0]);
        this.feePercentageOfTransactionValue = DataConverter.convertToFloat(feeWagesColumns[1]);
    }

    public Long getTransactionValueLessThan() {
        return transactionValueLessThan;
    }

    public void setTransactionValueLessThan(Long transactionValueLessThan) {
        this.transactionValueLessThan = transactionValueLessThan;
    }

    public float getFeePercentageOfTransactionValue() {
        return feePercentageOfTransactionValue;
    }

    public void setFeePercentageOfTransactionValue(float feePercentageOfTransactionValue) {
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }
}
