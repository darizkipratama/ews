package com.sipdasrh.ews.service.impl;

import com.sipdasrh.ews.domain.SpasArrInstall;
import com.sipdasrh.ews.domain.SpasArrLog;
import com.sipdasrh.ews.repository.SpasArrInstallRepository;
import com.sipdasrh.ews.repository.SpasArrLogRepository;
import com.sipdasrh.ews.service.SpasSensorService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class SpasSensorServiceImpl implements SpasSensorService {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(SpasSensorServiceImpl.class);

    private final SpasArrInstallRepository spasArrInstallRepository;
    private final SpasArrLogRepository spasArrLogRepository;

    public SpasSensorServiceImpl(SpasArrInstallRepository spasArrInstallRepository, SpasArrLogRepository spasArrLogRepository) {
        this.spasArrInstallRepository = spasArrInstallRepository;
        this.spasArrLogRepository = spasArrLogRepository;
    }

    @Override
    public void getDataFromSensors() {
        LOG.info("Get Data From Sensors API : Start at {}", LocalDate.now());
        List<SpasArrInstall> spasArrLogList = spasArrInstallRepository.findAll();
        spasArrLogList.forEach(spasArrLog -> {
            LOG.info("Get Data From Sensors API : Sensor {}", spasArrLog.getNamaInstalasi());
            String res = restTemplate.getForObject(spasArrLog.getUrlInstalasi(), String.class);
            JsonParser springParser = JsonParserFactory.getJsonParser();
            Map<String, Object> mapResult = springParser.parseMap(res);
            if (mapResult.get("statusCode").equals(200)) {
                LOG.info("Extract Data From Sensors API : {}", spasArrLog.getNamaInstalasi());
                Map<String, Object> sensorData = (Map<String, Object>) mapResult.get("data");
                String lastSending = sensorData.get("last_sending").toString();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);
                ZonedDateTime localizedDate = ZonedDateTime.parse(lastSending, formatter);

                Map<String, Object> sensorDetail = (Map<String, Object>) sensorData.get("sensor");
                Map<String, Object> waterLevel = (Map<String, Object>) sensorDetail.get("Water Level");
                Integer waterLevelInteger = (Integer) waterLevel.get("value_actual");
                String waterLevelUnit = waterLevel.get("unit").toString();
                SpasArrLog newData = new SpasArrLog()
                    .logValue(sensorDetail.toString())
                    .timeLog(localizedDate)
                    .timeRetrieve(ZonedDateTime.now())
                    .spasArrInstall(spasArrLog);
                spasArrLogRepository.saveAndFlush(newData);
            }
        });
        LOG.info("Get Data From Sensors API : End at {}", LocalDate.now());
    }
}
