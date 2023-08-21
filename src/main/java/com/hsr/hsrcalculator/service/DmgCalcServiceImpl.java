/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.DmgRequest;
import com.hsr.hsrcalculator.entity.DmgResponse;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

/**
 *
 * @author Arcy
 */
@Service
public class DmgCalcServiceImpl implements DmgCalcService{
    DmgResponse resp = new DmgResponse();
    
    public DmgCalcServiceImpl() {
        super();
    }
    @Override
    public BigDecimal skillDmg(BigDecimal attack, BigDecimal skillMultiplier) {
        return ((attack.multiply(skillMultiplier)).divide(BigDecimal.valueOf(100)));
    }

    @Override
    public BigDecimal dmgBonus(BigDecimal elementDmg, BigDecimal dmgBoost) {
        return ((BigDecimal.valueOf(100).add(elementDmg)).add(dmgBoost));
    }

    @Override
    public BigDecimal defMultiplier(BigDecimal charLvl, BigDecimal enemiesLvl, BigDecimal defReduc, BigDecimal defIgnore) {
        BigDecimal lvlChar = charLvl.add(BigDecimal.valueOf(20));
        BigDecimal lvlEnemies = (enemiesLvl.add(BigDecimal.valueOf(20)))
                .multiply(((BigDecimal.valueOf(100).subtract(defReduc)).subtract(defIgnore)).divide(BigDecimal.valueOf(100)));
        
        BigDecimal defMultiply = lvlChar.divide((lvlEnemies.add(lvlChar)), 2, RoundingMode.HALF_UP);
        
        return defMultiply;
    }

    @Override
    public BigDecimal isEnemiesWeakToCorrespondingElement(Boolean var, BigDecimal resPen) {
        if (var) {
            return BigDecimal.valueOf(100).add(resPen);
        }
        return BigDecimal.valueOf(80).add(resPen);
    }

    @Override
    public BigDecimal dmgTakenBonus(BigDecimal dmgTakenDebuff) {
        return BigDecimal.valueOf(100).add(dmgTakenDebuff);
    }

    @Override
    public BigDecimal isEnemiesInBreakState(Boolean var) {
        if (var) {
            return BigDecimal.valueOf(100);
        }
        return BigDecimal.valueOf(90);
    }

    @Override
    public DmgResponse dmgCalculating(DmgRequest req) {
        Boolean weakness = true, breakState = true;
        BigDecimal percent = BigDecimal.valueOf(100);
        if (req.getIsEnemiesWeak().equalsIgnoreCase("false")) {
            weakness = false;
        }
        if (req.getIsEnemiesBreakState().equalsIgnoreCase("false")) {
            breakState = false;
        }
        BigDecimal skillDmg = this.skillDmg(new BigDecimal(req.getAttack().toString()), new BigDecimal(req.getSkillMultiplier().toString()));
        BigDecimal dmgBonus = (this.dmgBonus(new BigDecimal(req.getElementDmg().toString()), new BigDecimal(req.getDmgBoost().toString()))).divide(percent);
        BigDecimal defMultiply = this.defMultiplier(new BigDecimal(req.getCharLvl().toString()), new BigDecimal(req.getEnemiesLvl().toString()),
                new BigDecimal(req.getDefReduc().toString()), new BigDecimal(req.getDefIgnore().toString()));
        BigDecimal weaknessMultiply = (this.isEnemiesWeakToCorrespondingElement(weakness, new BigDecimal(req.getResPen().toString()))).divide(percent);
        BigDecimal dmgTaken = (this.dmgTakenBonus(new BigDecimal(req.getDmgTakenDebuff().toString()))).divide(percent);
        BigDecimal breakMultiply = (this.isEnemiesInBreakState(breakState)).divide(percent);
        BigDecimal dmgOutput = BigDecimal.ZERO;
        BigDecimal critDmgOutput = BigDecimal.ZERO;
        BigDecimal critDmg = new BigDecimal(req.getCritDmg().toString());
        
        dmgOutput = skillDmg.multiply(dmgBonus).multiply(defMultiply)
                .multiply(weaknessMultiply).multiply(dmgTaken)
                .multiply(breakMultiply);
        
        critDmgOutput = dmgOutput.add(dmgOutput.multiply(critDmg).divide(percent));
        Float dmgOut = dmgOutput.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        Float critOut = critDmgOutput.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        this.resp.setEstdDmgOutput(dmgOut.toString());
        this.resp.setEstdCritDmgOutput(critOut.toString());
        
        return this.resp;
    }
    
}
