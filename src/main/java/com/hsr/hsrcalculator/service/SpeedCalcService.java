package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.SpeedCycleRequest;
import com.hsr.hsrcalculator.entity.SpeedCycleResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedCalcService {

    public SpeedCycleResponse spdCalculating(SpeedCycleRequest req);
}
