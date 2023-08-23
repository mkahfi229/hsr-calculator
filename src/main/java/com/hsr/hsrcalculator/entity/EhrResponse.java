package com.hsr.hsrcalculator.entity;

import org.springframework.beans.factory.annotation.Value;

public class EhrResponse {

    @Value("0")
    private String ehrNeeded;

    public String getEhrNeeded() {
        return ehrNeeded;
    }

    public void setEhrNeeded(String ehrNeeded) {
        this.ehrNeeded = ehrNeeded;
    }
}
