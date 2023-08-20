/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hsr.hsrcalculator.controller;

import com.hsr.hsrcalculator.entity.DmgRequest;
import com.hsr.hsrcalculator.entity.DmgResponse;
import com.hsr.hsrcalculator.entity.HelloRequest;
import com.hsr.hsrcalculator.entity.HelloResponse;
import com.hsr.hsrcalculator.service.DmgCalcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arcy
 */
@RestController
public class DmgCalcController {
    
    @Autowired
    private DmgCalcServiceImpl dmgCalcService;
    
    @GetMapping("hsr/dmg")
    public ResponseEntity<DmgResponse> getDmgOutput(@RequestBody DmgRequest req) {
        try {
            DmgResponse resp = dmgCalcService.dmgCalculating(req);
            
            return new ResponseEntity<DmgResponse>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("hsr/helloreq")
    public ResponseEntity<HelloResponse> getHello(@RequestBody HelloRequest req) {
        try {
            HelloResponse resp = new HelloResponse();
            resp.setTest(req.getTest());
            
            return new ResponseEntity<HelloResponse>(resp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
            
    @GetMapping("hsr/hello")
    public String hello() {
        return "Hello, this is Honkai:Star Rail Damage Calculator !!";
    }

}
