package com.recruitment.task.models;

import com.recruitment.task.utils.DataConverter;

public class FeeWage {

    private Long maxValue;
    private float feePercentageOfTransactionValue;

    public FeeWage() {
    }

    public FeeWage(Long maxValue, float feePercentageOfTransactionValue) {
        this.maxValue = maxValue;
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }

    public FeeWage(String[] feeWagesColumns) {
        this.maxValue = DataConverter.convertToLong(feeWagesColumns[0]);
        this.feePercentageOfTransactionValue = DataConverter.convertToFloat(feeWagesColumns[1]);
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    public float getFeePercentageOfTransactionValue() {
        return feePercentageOfTransactionValue;
    }

    public void setFeePercentageOfTransactionValue(float feePercentageOfTransactionValue) {
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }
}
