package com.hsr.hsrcalculator.service;

import com.hsr.hsrcalculator.entity.SpeedCycleRequest;
import com.hsr.hsrcalculator.entity.SpeedCycleResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SpeedCalcServiceImpl implements SpeedCalcService{
    @Override
    public SpeedCycleResponse spdCalculating(SpeedCycleRequest req) {
        SpeedCycleResponse resp = new SpeedCycleResponse();
        Float base = Float.valueOf(10000);
        Float speed = Float.valueOf(req.getSpd());

        Float av = base / speed;

        resp.setActionValue(av.toString());
        resp.setTurnPer3Cycles(turnPer3Cycles(av));
        resp.setTurnPer5Cycles(turnPer5Cycles(av));
        resp.setTurnPer10Cycles(turnPer10Cycles(av));

        return resp;
    }

    private String turnPer3Cycles(Float av) {
        Integer turn = 0;
        Float startAv = av;
        for (int i = 0; startAv < 450;) {
            startAv = startAv + av;
            turn++;
        }
        return turn.toString();
    }

    private String turnPer5Cycles(Float av) {
        Integer turn = 0;
        Float startAv = av;
        for (int i = 0; startAv < 650;) {
            startAv = startAv + av;
            turn++;
        }
        return turn.toString();
    }

    private String turnPer10Cycles(Float av) {
        Integer turn = 0;
        Float startAv = av;
        for (int i = 0; startAv < 1150;) {
            startAv = startAv + av;
            turn++;
        }
        return turn.toString();
    }
}
