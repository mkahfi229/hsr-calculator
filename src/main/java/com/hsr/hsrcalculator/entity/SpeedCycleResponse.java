package com.hsr.hsrcalculator.entity;

import org.springframework.beans.factory.annotation.Value;

public class SpeedCycleResponse {

    @Value("0")
    private String actionValue;

    @Value("0")
    private String turnPer3Cycles;

    @Value("0")
    private String turnPer5Cycles;

    @Value("0")
    private String turnPer10Cycles;

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String actionValue) {
        this.actionValue = actionValue;
    }

    public String getTurnPer3Cycles() {
        return turnPer3Cycles;
    }

    public void setTurnPer3Cycles(String turnPer3Cycles) {
        this.turnPer3Cycles = turnPer3Cycles;
    }

    public String getTurnPer5Cycles() {
        return turnPer5Cycles;
    }

    public void setTurnPer5Cycles(String turnPer5Cycles) {
        this.turnPer5Cycles = turnPer5Cycles;
    }

    public String getTurnPer10Cycles() {
        return turnPer10Cycles;
    }

    public void setTurnPer10Cycles(String turnPer10Cycles) {
        this.turnPer10Cycles = turnPer10Cycles;
    }
}
