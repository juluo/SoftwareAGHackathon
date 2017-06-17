package org.softwareag.hackthon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.response.StartResponse;
import org.softwareag.hackthon.service.RoutePlanner;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uber.ServerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.uber.sdk.rides.client.UberRidesApi;


/**
 * Created by rvignesh on 6/16/2017.
 */
@RestController
public class RequestController {

    @Autowired
    ServerToken serverToken;

    @Autowired
    FareEstimateService fareEstimateService;

    @Autowired
    GoogleDistanceService googleDistanceService;
    
    @Autowired
    private RoutePlanner routePlanner;

    final static Logger LOG = LoggerFactory.getLogger(RequestController.class);

    /***dummy controller to test uber integration***/
    @RequestMapping(value = "/startuber", method = RequestMethod.GET)
    public void startUber(){
        LOG.info(fareEstimateService.calculateFare().toString());
    }
    /** **/

    /***dummy controller to test google integration***/
    @RequestMapping(value = "/startgoogle", method = RequestMethod.GET)
    public void startGoogle(){
        LOG.info(googleDistanceService.getDistance(13.0000632f,80.2331078f,12.9862535f,80.2457295f).toString());
    }
    /** **/

    @RequestMapping(value = "/start",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void startRide(@RequestBody String requestbody){
      LOG.info(requestbody);
        StartResponse response = new StartResponse();
        response.setStatus(200);
        response.setTripId("12345");
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void detail(@RequestBody String requestbody){
        LOG.info(requestbody);
        StartResponse response = new StartResponse();
        response.setStatus(200);
        response.setTripId("12345");
    }

    @RequestMapping(value = "/detail",method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void detail(@RequestBody String requestbody){
        LOG.info(requestbody);
        StartResponse response = new StartResponse();
        response.setStatus(200);
        response.setTripId("12345");
    }


}
