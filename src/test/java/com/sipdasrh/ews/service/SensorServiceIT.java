package com.sipdasrh.ews.service;

import static org.mockito.Mockito.when;

import com.sipdasrh.ews.domain.SpasArrInstall;
import com.sipdasrh.ews.domain.SpasArrLog;
import com.sipdasrh.ews.repository.SpasArrInstallRepository;
import com.sipdasrh.ews.repository.SpasArrLogRepository;
import com.sipdasrh.ews.service.dto.SpasArrInstallDTO;
import com.sipdasrh.ews.service.impl.SpasArrInstallServiceImpl;
import com.sipdasrh.ews.service.impl.SpasArrLogServiceImpl;
import com.sipdasrh.ews.service.mapper.SpasArrInstallMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class SensorServiceIT {

    @Mock
    private SpasArrInstallRepository spasArrInstallRepository;

    @Mock
    private SpasArrLogRepository spasArrLogRepository;

    @InjectMocks
    private SpasArrLogServiceImpl spasArrLogService;

    @InjectMocks
    private SpasArrInstallServiceImpl spasArrInstallService;

    @Autowired
    private SpasArrInstallMapper spasArrInstallMapper;

    private SpasArrInstall spasArrInstall;

    @BeforeEach
    public void setup() {
        spasArrInstall = new SpasArrInstall()
            .id(1L)
            .namaInstalasi("test instalasi")
            .longInstalasi(1.0)
            .latInstalasi(-2.0)
            .urlInstalasi("https://tatonas.co.id/api/v2/realtime?uc=Se0q6pbR_all_bpdas_v2&pc=039&hw=4126");
    }

    @Test
    void assertSensorGetter() {
        System.out.println("Running Test Get Data From Sensor");
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        String res = restTemplate.getForObject(spasArrInstall.getUrlInstalasi(), String.class);
        Assert.assertNotNull(res);
    }
}
