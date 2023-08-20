/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.DmgRequest;
import com.hsr.hsrcalculator.entity.DmgResponse;
import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Arcy
 */
@Repository
public interface DmgCalcService{
    
    public BigDecimal skillDmg(BigDecimal attack, BigDecimal skillMultiplier);
    
    public BigDecimal dmgBonus(BigDecimal elementDmg, BigDecimal dmgBoost);
    
    public BigDecimal defMultiplier(BigDecimal charLvl, BigDecimal enemiesLvl, BigDecimal defReduc, BigDecimal defIgnore);
    
    public BigDecimal isEnemiesWeakToCorrespondingElement(Boolean var, BigDecimal resPen);
    
    public BigDecimal dmgTakenBonus(BigDecimal dmgTakenDebuff);
    
    public BigDecimal isEnemiesInBreakState(Boolean var);
    
    public DmgResponse dmgCalculating(DmgRequest req);
    
}
