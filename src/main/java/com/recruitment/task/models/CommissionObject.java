package com.recruitment.task.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class CommissionObject {

    @Id
    private String id;
    private Long customerId;
    private float calculatedCommision;
    private Date timeOfCalculation;

    public CommissionObject() {
    }

    public CommissionObject(String id, Long customerId, float calculatedCommision, Date timeOfCalculation) {
        this.id = id;
        this.customerId = customerId;
        this.calculatedCommision = calculatedCommision;
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

    public float getCalculatedCommision() {
        return calculatedCommision;
    }

    public void setCalculatedCommision(float calculatedCommision) {
        this.calculatedCommision = calculatedCommision;
    }

    public Date getTimeOfCalculation() {
        return timeOfCalculation;
    }

    public void setTimeOfCalculation(Date timeOfCalculation) {
        this.timeOfCalculation = timeOfCalculation;
    }
}
