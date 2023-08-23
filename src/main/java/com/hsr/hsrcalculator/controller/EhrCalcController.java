package com.hsr.hsrcalculator.controller;

import com.hsr.hsrcalculator.entity.*;
import com.hsr.hsrcalculator.service.EhrCalcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EhrCalcController {

    @Autowired
    private EhrCalcServiceImpl ehrCalcService;

    @CrossOrigin
    @PostMapping("hsr/ehr")
    public ResponseEntity<EhrResponse> getEhrNeeded(@RequestBody EhrRequest req) {
        try {
            EhrResponse resp = ehrCalcService.ehrCalculating(req);

            return new ResponseEntity<EhrResponse>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PostMapping("hsr/realchance")
    public ResponseEntity<RealChancesResponse> getRealChance(@RequestBody RealChancesRequest req) {
        try {
            RealChancesResponse resp = ehrCalcService.realChanceCalculating(req);

            return new ResponseEntity<RealChancesResponse>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
