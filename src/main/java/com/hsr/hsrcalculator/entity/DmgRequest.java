/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsr.hsrcalculator.entity;

import com.sun.istack.NotNull;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Arcy
 */
public class DmgRequest {
    
    @Value("0")
    private String attack;
    
    @Value("0")
    private String skillMultiplier;
    
    @Value("0")
    private String elementDmg;
    
    @Value("0")
    private String dmgBoost;
    
    @Value("1")
    private String charLvl;
    
    @Value("1")
    private String enemiesLvl;
    
    @Value("0")
    private String defReduc;
    
    @Value("0")
    private String defIgnore;
    
    @Value("true")
    private String isEnemiesWeak;
    
    @Value("0")
    private String dmgTakenDebuff;
    
    @Value("true")
    private String isEnemiesBreakState;
    
    @Value("0")
    private String critDmg;

    @Value("0")
    private String resPen;

    public String getResPen() {
        return resPen;
    }

    public void setResPen(String resPen) {
        this.resPen = resPen;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getSkillMultiplier() {
        return skillMultiplier;
    }

    public void setSkillMultiplier(String skillMultiplier) {
        this.skillMultiplier = skillMultiplier;
    }

    public String getElementDmg() {
        return elementDmg;
    }

    public void setElementDmg(String elementDmg) {
        this.elementDmg = elementDmg;
    }

    public String getDmgBoost() {
        return dmgBoost;
    }

    public void setDmgBoost(String dmgBoost) {
        this.dmgBoost = dmgBoost;
    }

    public String getCharLvl() {
        return charLvl;
    }

    public void setCharLvl(String charLvl) {
        this.charLvl = charLvl;
    }

    public String getEnemiesLvl() {
        return enemiesLvl;
    }

    public void setEnemiesLvl(String enemiesLvl) {
        this.enemiesLvl = enemiesLvl;
    }

    public String getDefReduc() {
        return defReduc;
    }

    public void setDefReduc(String defReduc) {
        this.defReduc = defReduc;
    }

    public String getDefIgnore() {
        return defIgnore;
    }

    public void setDefIgnore(String defIgnore) {
        this.defIgnore = defIgnore;
    }

    public String getIsEnemiesWeak() {
        return isEnemiesWeak;
    }

    public void setIsEnemiesWeak(String isEnemiesWeak) {
        this.isEnemiesWeak = isEnemiesWeak;
    }

    public String getDmgTakenDebuff() {
        return dmgTakenDebuff;
    }

    public void setDmgTakenDebuff(String dmgTakenDebuff) {
        this.dmgTakenDebuff = dmgTakenDebuff;
    }

    public String getIsEnemiesBreakState() {
        return isEnemiesBreakState;
    }

    public void setIsEnemiesBreakState(String isEnemiesBreakState) {
        this.isEnemiesBreakState = isEnemiesBreakState;
    }

    public String getCritDmg() {
        return critDmg;
    }

    public void setCritDmg(String critDmg) {
        this.critDmg = critDmg;
    }

    
}
