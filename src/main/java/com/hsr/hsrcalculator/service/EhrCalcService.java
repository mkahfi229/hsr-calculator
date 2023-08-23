package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.EhrRequest;
import com.hsr.hsrcalculator.entity.EhrResponse;
import com.hsr.hsrcalculator.entity.RealChancesRequest;
import com.hsr.hsrcalculator.entity.RealChancesResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface EhrCalcService {

    public EhrResponse ehrCalculating(EhrRequest req);

    public RealChancesResponse realChanceCalculating(RealChancesRequest req);
}
