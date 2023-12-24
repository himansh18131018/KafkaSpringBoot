package com.enduser.enduser;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {



    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String value){

        System.out.println(value);
    }
}
