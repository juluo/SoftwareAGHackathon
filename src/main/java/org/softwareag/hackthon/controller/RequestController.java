package org.softwareag.hackthon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uber.ServerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


}
