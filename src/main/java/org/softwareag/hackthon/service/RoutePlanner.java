/**
 * 
 */
package org.softwareag.hackthon.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.softwareag.hackthon.entity.ShareDetails;
import org.softwareag.hackthon.entity.SuggestedRouteDetails;
import org.softwareag.hackthon.google.GoogleDistanceService;
import org.softwareag.hackthon.googlebo.Distance;
import org.softwareag.hackthon.googlebo.Duration;
import org.softwareag.hackthon.repo.ShareDetailsRepo;
import org.softwareag.hackthon.repo.SuggestedRouteDetailsRepo;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uberboobjects.FareEstimateBO;
import org.softwareag.hackthon.uberboobjects.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	
	@Autowired
	private SuggestedRouteDetailsRepo suggestedRouteDetailsRepo;
	

	public Route getBestRoute(Trip primary, Trip secondary) {

		int primaryPriceFactor = getPriceFactor(primary.getPrice(), secondary.getPrice());
		// int secPriceFactor = 100 - primaryPriceFactor;

		try {
			Route route1 = getRoute1(primary, secondary);
			Route route2 = getRoute2(primary, secondary);
			Route route3 = getRoute3(primary, secondary);
			Route route4 = getRoute4(primary, secondary);

			// s1-s2-e2-e1
			Route bestRoute = route1;
			bestRoute.setPrinaryStartIn(0);
			bestRoute.setSecondaryStartIn(getDuration(primary.getFrom(), secondary.getFrom()));
			bestRoute.setPrimaryPrice(getPrice(bestRoute.getPrice(), primaryPriceFactor));
			bestRoute.setSecondaryPrice(bestRoute.getPrice() - bestRoute.getPrimaryPrice());
			int primaryDelay = (int) (bestRoute.getTime() - primary.getDuration());
			int secDelay = 0;
			bestRoute.setPrimaryTime(primaryDelay > 0 ? primaryDelay : 0);
			bestRoute.setSecondaryTime(secDelay > 0 ? secDelay : 0);

			// s2-s1-e2-e1
			if (route2.getTime() < bestRoute.getTime()) {
				bestRoute = route2;
				bestRoute.setPrinaryStartIn(getDuration(secondary.getFrom(), primary.getFrom()));
				bestRoute.setSecondaryStartIn(0);
				bestRoute.setPrimaryPrice(getPrice(bestRoute.getPrice(), primaryPriceFactor));
				bestRoute.setSecondaryPrice(bestRoute.getPrice() - bestRoute.getPrimaryPrice());
				primaryDelay = (int) (getDuration(primary.getFrom(), secondary.getTo())
						+ getDuration(secondary.getTo(), primary.getTo()) - primary.getDuration());
				secDelay = 0;
				bestRoute.setPrimaryTime(primaryDelay > 0 ? primaryDelay : 0);
				bestRoute.setSecondaryTime(secDelay > 0 ? secDelay : 0);
			}
			// s1-s2-e1-e2
			if (route3.getTime() < bestRoute.getTime()) {
				bestRoute = route3;
				bestRoute.setPrinaryStartIn(0);
				bestRoute.setSecondaryStartIn(getDuration(primary.getFrom(), secondary.getFrom()));
				bestRoute.setPrimaryPrice(getPrice(bestRoute.getPrice(), primaryPriceFactor));
				bestRoute.setSecondaryPrice(bestRoute.getPrice() - bestRoute.getPrimaryPrice());
				primaryDelay = 0;
				secDelay = (int) (getDuration(primary.getFrom(), secondary.getFrom())
						+ getDuration(primary.getTo(), secondary.getTo()) - primary.getDuration());
				bestRoute.setPrimaryTime(primaryDelay > 0 ? primaryDelay : 0);
				bestRoute.setSecondaryTime(secDelay > 0 ? secDelay : 0);
			}
			// s2-s1-e1-e2
			if (route4.getTime() < bestRoute.getTime()) {
				bestRoute = route4;
				bestRoute.setPrinaryStartIn(0);
				bestRoute.setSecondaryStartIn(getDuration(primary.getFrom(), secondary.getFrom()));
				bestRoute.setPrimaryPrice(getPrice(bestRoute.getPrice(), primaryPriceFactor));
				bestRoute.setSecondaryPrice(bestRoute.getPrice() - bestRoute.getPrimaryPrice());
				primaryDelay = 0;
				secDelay = (int) (bestRoute.getTime() - secondary.getDuration());
				bestRoute.setPrimaryTime(primaryDelay > 0 ? primaryDelay : 0);
				bestRoute.setSecondaryTime(secDelay > 0 ? secDelay : 0);
			}

			bestRoute.setPrimaryUser(primary.getUserId());
			bestRoute.setSecondaryUser(secondary.getUserId());

			return bestRoute;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private double getPrice(double price, int primaryPriceFactor) {
		return new BigDecimal((price * primaryPriceFactor) / 100).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
	}

	private int getPriceFactor(double price1, double price2) {

		return new BigDecimal((price1 / (price1 + price2)) * 100).setScale(2, BigDecimal.ROUND_HALF_EVEN).intValue();
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
		FareEstimateBO fareEstimateBO = fareSrvc.getFareEstimate(start.getLat(),start.getLon(),end.getLat(),end.getLon());
		List<Price> priceList = fareEstimateBO.getPrices();
		return priceList.stream()
				.filter(e -> e.getDisplayName().contentEquals("uberGO"))
				.mapToDouble(Price::getHighEstimate)
				.sum();
	}

	private long getDuration(Location start, Location end) {
		Duration duration = distanceSrvc.getDuration(start.getLat(),start.getLon(),end.getLat(),end.getLon());
		return Math.round(duration.getValue()/60);
	}

	private List<Route> processTripDetails(Trip trip) {
		ShareDetails shareDetails = processInputAndSaveEntity(trip);
		Trip primary = getTripDetails(shareDetails);
		List<ShareDetails> shareDetailsList =  shareDetailsRepo.findByInActiveOrderById(true);
		List<SuggestedRouteDetails> suggestedRouteDetailsList = new LinkedList<SuggestedRouteDetails>();
		List<Route> routeList = new LinkedList<Route>();
		if(!CollectionUtils.isEmpty(shareDetailsList)){
			for (ShareDetails iterShareDetail : shareDetailsList) {
				Trip secodary = getTripDetails(iterShareDetail);
				Route route = getBestRoute(primary, secodary);
				SuggestedRouteDetails suggestedRouteDetails = new SuggestedRouteDetails();
				suggestedRouteDetails.setPrimaryUser(shareDetails.getUserId());
				suggestedRouteDetails.setSecondaryUser(iterShareDetail.getUserId());
				suggestedRouteDetails.setPrimaryPrice(route.getPrimaryPrice());
				suggestedRouteDetails.setSecondaryPrice(route.getSecondaryPrice());
				suggestedRouteDetails.setPrimaryTime(route.getPrimaryTime());
				suggestedRouteDetails.setSecondaryTime(route.getSecondaryTime());
				suggestedRouteDetails.setPrimaryStartIn(route.getPrinaryStartIn());
				suggestedRouteDetails.setSecondaryStartIn(route.getSecondaryStartIn());
				suggestedRouteDetails.setCombinedEndLat(route.getEnd().getLat());
				suggestedRouteDetails.setCombinedEndLong(route.getEnd().getLon());
				suggestedRouteDetails.setCombinedStartLat(route.getStart().getLat());
				suggestedRouteDetails.setCombinedStartLong(route.getStart().getLon());
				suggestedRouteDetails.setPrice(route.getPrice());
				suggestedRouteDetails.setTime(route.getTime());
				setAllFourPointString(route, suggestedRouteDetails);
				suggestedRouteDetails = suggestedRouteDetailsRepo.save(suggestedRouteDetails);
				route.setId(suggestedRouteDetails.getId());
				routeList.add(route);
			}
			return routeList;
		}
		return null;
	}

	private void setAllFourPointString(Route route, SuggestedRouteDetails suggestedRouteDetails) {
		int count = 1;
		for (Location loc : route.getRouteMap()) {
			if(count < 2){
				suggestedRouteDetails.setPoint1(loc.getLon() + "," + loc.getLat());
				count++;
			} else if(count < 3) {
				suggestedRouteDetails.setPoint2(loc.getLon() + "," + loc.getLat());
				count++;
			} else if(count < 4) {
				suggestedRouteDetails.setPoint3(loc.getLon() + "," + loc.getLat());
				count++;
			} else if(count < 5) {
				suggestedRouteDetails.setPoint4(loc.getLon() + "," + loc.getLat());
				count++;
			}
		}
	}	

	private Trip getTripDetails(ShareDetails shareDetail) {
		Trip trip = new Trip();
		trip.setUserId(shareDetail.getUserId());
		Location from = new Location();
		from.setLat(shareDetail.getStartLat());
		from.setLon(shareDetail.getStartLong());
		trip.setFrom(from );
		Location to = new Location();
		to.setLat(shareDetail.getStopLat());
		to.setLon(shareDetail.getStopLong());
		trip.setTo(to);
		trip.setPrice(shareDetail.getPrice());
		trip.setDuration(shareDetail.getDuration());
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
		shareDetails.setInActive(false);
		shareDetails = shareDetailsRepo.save(shareDetails);
		return shareDetails;		
	}

}
