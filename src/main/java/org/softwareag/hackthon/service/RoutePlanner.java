/**
 * 
 */
package org.softwareag.hackthon.service;

import java.util.List;

import org.softwareag.hackthon.entity.ShareDetails;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.googlebo.Distance;
import org.softwareag.hackthon.repo.ShareDetailsRepo;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uberboobjects.FareEstimateBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author prasad
 *
 */
@Service
public class RoutePlanner {

	@Autowired
	private GoogleDistanceService distanceSrvc;

	@Autowired
	private FareEstimateService fareSrvc;
	
	@Autowired
	private ShareDetailsRepo shareDetailsRepo;

	public Route getBestRoute(Trip primary, Trip secondary) {

		try {
			Route route1 = getRoute1(primary, secondary);
			Route route2 = getRoute2(primary, secondary);
			Route route3 = getRoute3(primary, secondary);
			Route route4 = getRoute4(primary, secondary);

			Route bestRoute = route1;

			if (route2.getTime() < bestRoute.getTime()) {
				bestRoute = route2;
			}

			if (route3.getTime() < bestRoute.getTime()) {
				bestRoute = route3;
			}

			if (route4.getTime() < bestRoute.getTime()) {
				bestRoute = route4;
			}

			return bestRoute;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Route getRoute1(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(one.getFrom(), two.getFrom(), two.getTo(), one.getTo());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(two.getTo());
		route.getRouteMap().add(one.getTo());
		route.setStart(one.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(), route.getEnd()));

		return route;
	}

	private Route getRoute2(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(two.getFrom(), one.getFrom(), two.getTo(), one.getTo());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getTo());
		route.getRouteMap().add(one.getTo());
		route.setStart(two.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(), route.getEnd()));

		return route;
	}

	private Route getRoute3(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(one.getFrom(), two.getFrom(), one.getTo(), two.getTo());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getTo());
		route.getRouteMap().add(two.getTo());
		route.setStart(one.getFrom());
		route.setEnd(two.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(), route.getEnd()));

		return route;
	}

	private Route getRoute4(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(two.getFrom(), one.getFrom(), one.getTo(), two.getTo());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(one.getTo());
		route.getRouteMap().add(two.getTo());
		route.setStart(one.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(), route.getEnd()));

		return route;
	}

	public long routeTime(Location one, Location two, Location three, Location four) {
		long duration = getDuration(one, two) + getDuration(two, three) + getDuration(three, four);
		return duration;
	}

	private double getPrice(Location start, Location end) {
		FareEstimateBO fareEstimate = fareSrvc.getFareEstimate(start.getLat(), start.getLon(), end.getLat(),
				end.getLon());
		return 0;
	}

	private long getDuration(Location start, Location end) {
		Distance distance = distanceSrvc.getDistance(start.getLat(), start.getLon(), end.getLat(), end.getLon());
		return distance.getValue();
	}

	private List<Route> processTripDetails(Trip trip) {
		ShareDetails shareDetails = processInputAndSaveEntity(trip);
		return null;

	}

	private ShareDetails processInputAndSaveEntity(Trip trip) {
		ShareDetails shareDetails = new ShareDetails();
		shareDetails.setUserId(trip.getUserId());
		shareDetails.setStartLat(trip.getFrom().getLat());
		shareDetails.setStartLong(trip.getFrom().getLon());
		shareDetails.setStopLat(trip.getTo().getLat());
		shareDetails.setStopLong(trip.getTo().getLon());
		shareDetails.setDuration(getDuration(trip.getFrom(), trip.getTo()));
		shareDetails.setPrice(getPrice(trip.getFrom(), trip.getTo()));
		shareDetails = shareDetailsRepo.save(shareDetails);
		return shareDetails;		
	}

}
