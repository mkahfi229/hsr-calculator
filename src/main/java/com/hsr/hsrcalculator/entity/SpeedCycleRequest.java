package com.hsr.hsrcalculator.entity;

import org.springframework.beans.factory.annotation.Value;

public class SpeedCycleRequest {

    @Value("0")
    private String spd;

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }
}
