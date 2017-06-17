package org.softwareag.hackthon.uber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.service.RestService;
import org.softwareag.hackthon.uberboobjects.FareEstimateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rvignesh on 6/17/2017.
 */
@Service
public class FareEstimateService {

    final static Logger LOG = LoggerFactory.getLogger(FareEstimateService.class);

    @Autowired
    RestService restService;

    String url = "https://api.uber.com/v1.2/estimates/price?start_latitude=<STARTLAT>&start_longitude=<STARTLONG>&end_latitude=<ENDLAT>&end_longitude=<ENDLONG>&key=AIzaSyBcq3bZIduSisJaDMNUUMxha4cGGyWPFEI";


    public FareEstimateBO getFareEstimate(double start_latitude, double stop_longitude, double end_latitude, double end_longitude) {

        try {
            return restService.bindJsonToObj(restService.sendGet(url.replace("<STARTLAT>", String.valueOf(start_latitude))
                    .replace("<STARTLONG>", String.valueOf(stop_longitude))
                    .replace("<ENDLAT>", String.valueOf(end_latitude))
                    .replace("<ENDLONG>", String.valueOf(end_longitude)),true), FareEstimateBO.class);

        } catch (Exception e) {
            LOG.info(e.getMessage());
            throw new RuntimeException("Error while getting fare estimate");
        }
    }

    public FareEstimateBO calculateFare(){
        return getFareEstimate(13.0000632,80.2331078,12.9862535,80.2457295);
    }


}
