package com.hsr.hsrcalculator.controller;

import com.hsr.hsrcalculator.entity.SpeedCycleRequest;
import com.hsr.hsrcalculator.entity.SpeedCycleResponse;
import com.hsr.hsrcalculator.service.SpeedCalcService;
import com.hsr.hsrcalculator.service.SpeedCalcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeedCalcController {

    @Autowired
    private SpeedCalcServiceImpl spdCalcService;
    @CrossOrigin
    @PostMapping("hsr/speed")
    public ResponseEntity<SpeedCycleResponse> getSpeedCycle(@RequestBody SpeedCycleRequest req) {
        try {
            SpeedCycleResponse resp = spdCalcService.spdCalculating(req);

            return new ResponseEntity<SpeedCycleResponse>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
