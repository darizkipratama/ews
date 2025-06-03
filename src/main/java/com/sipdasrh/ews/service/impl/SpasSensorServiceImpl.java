package com.sipdasrh.ews.service.impl;

import com.sipdasrh.ews.domain.SpasArrInstall;
import com.sipdasrh.ews.repository.SpasArrInstallRepository;
import com.sipdasrh.ews.service.SpasSensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class SpasSensorServiceImpl implements SpasSensorService {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(SpasSensorServiceImpl.class);

    private final SpasArrInstallRepository spasArrInstallRepository;

    public SpasSensorServiceImpl(SpasArrInstallRepository spasArrInstallRepository) {
        this.spasArrInstallRepository = spasArrInstallRepository;
    }

    @Override
    public void getDataFromSensors() {
        LOG.info("Get Data From Sensors API : Start at {}", LocalDate.now());
        List<SpasArrInstall> spasArrLogList = spasArrInstallRepository.findAll();
        spasArrLogList.forEach(spasArrLog -> {
            LOG.info("Get Data From Sensors API : Sensor {}", spasArrLog.getNamaInstalasi());
            String res = restTemplate.getForObject(
                spasArrLog.getUrlInstalasi(),
                String.class
            );
            System.out.println(res);
        });
        LOG.info("Get Data From Sensors API : End at {}", LocalDate.now());
    }
}
