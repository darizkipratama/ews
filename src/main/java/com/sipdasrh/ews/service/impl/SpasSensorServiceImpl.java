package com.sipdasrh.ews.service.impl;

import com.sipdasrh.ews.service.SpasSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpasSensorServiceImpl implements SpasSensorService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void getDataFromSensors() {
        String res = restTemplate.getForObject(
            "https://tatonas.co.id/api/v2/realtime?uc=Se0q6pbR_all_bpdas_v2&pc=039&hw=4126",
            String.class
        );
        System.out.println(res);
    }
}
