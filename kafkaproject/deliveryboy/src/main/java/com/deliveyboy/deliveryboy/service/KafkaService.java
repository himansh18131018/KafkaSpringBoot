package com.deliveyboy.deliveryboy.service;

import com.deliveyboy.deliveryboy.config.AppConstants;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public boolean locationUpdate(String location){
        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
        this.logger.info("Location Updated");
        return true;
    }
}
