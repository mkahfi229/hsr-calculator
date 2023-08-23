package com.hsr.hsrcalculator.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

public class RealChancesRequest {

    @Value("0")
    private String baseChance;

    @Value("0")
    private String ehr;

    @Value("0")
    private String enemiesResist;

    @Value("0")
    private String resistReduc;

    public String getBaseChance() {
        return baseChance;
    }

    public void setBaseChance(String baseChance) {
        this.baseChance = baseChance;
    }

    public String getEhr() {
        return ehr;
    }

    public void setEhr(String ehr) {
        this.ehr = ehr;
    }

    public String getEnemiesResist() {
        return enemiesResist;
    }

    public void setEnemiesResist(String enemiesResist) {
        this.enemiesResist = enemiesResist;
    }

    public String getResistReduc() {
        return resistReduc;
    }

    public void setResistReduc(String resistReduc) {
        this.resistReduc = resistReduc;
    }
}
