package org.softwareag.hackthon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.response.StartResponse;
import org.softwareag.hackthon.service.RestService;
import org.softwareag.hackthon.service.RoutePlanner;
import org.softwareag.hackthon.service.Trip;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uber.ServerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    RestService service;
    @Autowired
    private RoutePlanner routePlanner;

    final static Logger LOG = LoggerFactory.getLogger(RequestController.class);

    /***dummy controller to test uber integration***/
    @RequestMapping(value = "/startuber", method = RequestMethod.GET)
    public void startUber(){
        LOG.info(fareEstimateService.calculateFare().toString());
    }
    /** **/


    @RequestMapping(value = "/start",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public StartResponse startRide(@RequestBody String requestbody) {
		LOG.info(requestbody);
		Trip trip = service.bindJsonToObj(requestbody, Trip.class);

		StartResponse response = new StartResponse();
		response.setStatus(200);
		return response;
	}




}
