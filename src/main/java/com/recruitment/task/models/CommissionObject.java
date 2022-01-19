package com.recruitment.task.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class CommissionObject {

    @Id
    private String id;
    private Long customerId;
    private float calculatedCommission;
    private Date timeOfCalculation;

    public CommissionObject() {
    }

    public CommissionObject(String id, Long customerId, float calculatedCommission, Date timeOfCalculation) {
        this.id = id;
        this.customerId = customerId;
        this.calculatedCommission = calculatedCommission;
        this.timeOfCalculation = timeOfCalculation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public float getCalculatedCommission() {
        return calculatedCommission;
    }

    public void setCalculatedCommission(float calculatedCommission) {
        this.calculatedCommission = calculatedCommission;
    }

    public Date getTimeOfCalculation() {
        return timeOfCalculation;
    }

    public void setTimeOfCalculation(Date timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }
}
