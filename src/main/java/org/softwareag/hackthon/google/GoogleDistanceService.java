package org.softwareag.hackthon.google;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.googlebo.Distance;
import org.softwareag.hackthon.googlebo.Duration;
import org.softwareag.hackthon.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rvignesh on 6/17/2017.
 */

@Service
public class GoogleDistanceService {

    @Autowired
    RestService restService;

    final static Logger LOG = LoggerFactory.getLogger(GoogleDistanceService.class);

    String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=<STARTLATLONG>&destinations=<ENDLATLONG>&key=";

    public Duration getDuration(double start_latitude, double stop_longitude, double end_latitude, double end_longitude) {

        try {
            return restService.bindJsonToObj(restService.sendGet(url.replace("<STARTLATLONG>", String.valueOf(start_latitude)+","+String.valueOf(stop_longitude))
                    .replace("<ENDLATLONG>", String.valueOf(end_latitude)+","+String.valueOf(end_longitude)),false), Duration.class);

        } catch (Exception e) {
            LOG.info(e.getMessage());
            throw new RuntimeException("Error while getting fare estimate");
        }
    }

}
