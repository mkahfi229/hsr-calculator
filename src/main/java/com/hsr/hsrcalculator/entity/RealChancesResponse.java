package com.hsr.hsrcalculator.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

public class RealChancesResponse {

    @Value("0")
    private String realChance;

    public String getRealChance() {
        return realChance;
    }

    public void setRealChance(String realChance) {
        this.realChance = realChance;
    }
}
