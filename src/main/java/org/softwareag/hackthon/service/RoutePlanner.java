/**
 * 
 */
package org.softwareag.hackthon.service;

import java.util.ArrayList;

/**
 * @author prasad
 *
 */
public class RoutePlanner {

	public static Route getBestRoute(Trip usr, Trip other){
		ArrayList<Location> cords = new ArrayList<>();
		cords.add(0, usr.getFrom());
		cords.add(1,other.getFrom());
		cords.add(2,other.getTo());
		cords.add(3,usr.getTo());
		
		Route route1 = getRoute1(usr,other);
		Route route2 = getRoute2(usr,other);
		Route route3 = getRoute3(usr,other);
		Route route4 = getRoute4(usr,other);
		
		Route bestRoute = route1;
		
		if(route2.getTime() < bestRoute.getTime()){
			bestRoute = route2;
		}

		if(route3.getTime() < bestRoute.getTime()){
			bestRoute = route3;
		}
		
		if(route4.getTime() < bestRoute.getTime()){
			bestRoute = route4;
		}
		
		
		return bestRoute;
	}
	private static Route getRoute1(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(one.getFrom(), two.getFrom(), two.getTo(), one.getTo());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(two.getTo());
		route.getRouteMap().add(one.getTo());
		route.setStart(one.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(),route.getEnd()));
		
		return route;
	}
	
	private static Route getRoute2(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(two.getFrom(), one.getFrom(), two.getTo(), one.getTo());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getTo());
		route.getRouteMap().add(one.getTo());
		route.setStart(two.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(),route.getEnd()));
		
		return route;
	}
	
	private static Route getRoute3(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(one.getFrom(), two.getFrom(), one.getTo(), two.getTo());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getTo());
		route.getRouteMap().add(two.getTo());
		route.setStart(one.getFrom());
		route.setEnd(two.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(),route.getEnd()));
		
		return route;
	}
	
	private static Route getRoute4(Trip one, Trip two) {
		Route route = new Route();
		long routeTime = routeTime(two.getFrom(), one.getFrom(), one.getTo(), two.getTo());
		route.getRouteMap().add(two.getFrom());
		route.getRouteMap().add(one.getFrom());
		route.getRouteMap().add(one.getTo());
		route.getRouteMap().add(two.getTo());
		route.setStart(one.getFrom());
		route.setEnd(one.getTo());
		route.setTime(routeTime);
		route.setPrice(getPrice(route.getStart(),route.getEnd()));
		
		return route;
	}
	
	public static long routeTime(Location one,Location two,Location three,Location four){
		long duration = getDuration(one,two) + getDuration(two,three) + getDuration(three,four);	
		return duration;
	}
	
	private static double getPrice(Location start, Location end) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static long getDuration(Location one, Location two) {
		// TODO Auto-generated method stub
		return 0;
	}
}
