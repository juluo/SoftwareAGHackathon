package org.softwareag.hackthon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.entity.SuggestedRouteDetails;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.response.StartResponse;
import org.softwareag.hackthon.service.Login;
import org.softwareag.hackthon.service.RestService;
import org.softwareag.hackthon.service.Route;
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
		trip.setDuration(routePlanner.getDuration(trip.getFrom(), trip.getTo()));
		trip.setPrice(routePlanner.getPrice(trip.getFrom(), trip.getTo()));
		List<Route> routes = routePlanner.processTripDetails(trip);
		StartResponse response = new StartResponse();
		response.setStatus(200);
		response.setRoutes(routes);
		return response;
	}

    @RequestMapping(value = "/accept",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Route accept(String userId, long routeId) {
    	Route route = routePlanner.acceptRoute(routeId);
    	if(route != null){
    		return routePlanner.acceptRoute(routeId);
    	}
    	
    	return null;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public StartResponse loginUser(@RequestBody String requestbody) {
		LOG.info(requestbody);
		Login login = service.bindJsonToObj(requestbody, Login.class);
		boolean result = routePlanner.login(login);
		StartResponse response = new StartResponse();
		response.setStatus(200);		
		return response;
	}
    
    @RequestMapping(value = "/get-status",method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public StartResponse getStatus(@RequestBody String userId) {
		LOG.info(userId);
		//Trip trip = service.bindJsonToObj(requestbody, Trip.class);
		//trip.setDuration(routePlanner.getDuration(trip.getFrom(), trip.getTo()));
		//trip.setPrice(routePlanner.getPrice(trip.getFrom(), trip.getTo()));
		List<SuggestedRouteDetails> routes = routePlanner.getStatus(userId);
		StartResponse response = new StartResponse();
		response.setStatus(200);
		response.setRouteList(routes);
		return response;
	}
    


}
