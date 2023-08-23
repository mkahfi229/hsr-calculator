package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.EhrRequest;
import com.hsr.hsrcalculator.entity.EhrResponse;
import com.hsr.hsrcalculator.entity.RealChancesRequest;
import com.hsr.hsrcalculator.entity.RealChancesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class EhrCalcServiceImpl implements EhrCalcService{

    EhrResponse resp = new EhrResponse();
    RealChancesResponse rcResp = new RealChancesResponse();

    public EhrCalcServiceImpl(){
        super();
    }

    @Override
    public EhrResponse ehrCalculating(EhrRequest req) {
        BigDecimal ehrNeeded = BigDecimal.ZERO;
        BigDecimal baseChance = new BigDecimal(req.getBaseChance().toString()).divide(BigDecimal.valueOf(100));
        BigDecimal enemiesResist = new BigDecimal(req.getEnemiesResist().toString()).divide(BigDecimal.valueOf(100));
        BigDecimal resistReduc = new BigDecimal(req.getResistReduc().toString()).divide(BigDecimal.valueOf(100));

        ehrNeeded = BigDecimal.valueOf(100).divide(baseChance, 0, RoundingMode.HALF_UP)
                .divide((BigDecimal.ONE.subtract(enemiesResist).add(resistReduc)), 0, RoundingMode.HALF_UP)
                .subtract(BigDecimal.valueOf(100));

        Float ehr = ehrNeeded.setScale(0, BigDecimal.ROUND_HALF_UP).floatValue();
        this.resp.setEhrNeeded(ehr.toString());

        return this.resp;
    }

    @Override
    public RealChancesResponse realChanceCalculating(RealChancesRequest req) {
        BigDecimal realChance = BigDecimal.ZERO;
        BigDecimal baseChance = new BigDecimal(req.getBaseChance().toString());
        BigDecimal ehr = BigDecimal.ONE.add(new BigDecimal(req.getEhr().toString()).divide(BigDecimal.valueOf(100)));
        BigDecimal enemiesResist = BigDecimal.ONE.subtract((new BigDecimal(req.getEnemiesResist().toString())
                .subtract(new BigDecimal(req.getResistReduc().toString()))).divide(BigDecimal.valueOf(100)));

        realChance = baseChance.multiply(ehr).multiply(enemiesResist);

        Float realCh = realChance.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
        this.rcResp.setRealChance(realCh.toString());

        return this.rcResp;
    }
}
