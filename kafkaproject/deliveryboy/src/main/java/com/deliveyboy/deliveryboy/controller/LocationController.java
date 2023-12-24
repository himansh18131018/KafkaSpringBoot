package com.deliveyboy.deliveryboy.controller;

import com.deliveyboy.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        for(int i=1;i<100000;i++) {
            this.kafkaService.locationUpdate("(" + Math.round(Math.random() * 1000) +
                    "," + Math.round(Math.random() * 1000) + ")");
        }
        return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
    }
}
