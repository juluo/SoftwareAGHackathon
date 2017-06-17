package org.softwareag.hackthon.uber;

import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.model.Product;
import com.uber.sdk.rides.client.model.Ride;
import com.uber.sdk.rides.client.model.RideRequestParameters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

import retrofit2.Response;

/**
 * Created by rvignesh on 6/17/2017.
 */
@Configuration
public class ServerToken {

    private final String CLIENTID = "IaftrSzT_KSshKwoz91hIt3ynUN-FgtO";
    private final String SERVERTOKEN = "x-mBrc32JTbPYIjlcvAWTaMw0Ea0mdxEwYr4F6eE";

    @Bean
    public ServerTokenSession getServerTokenSession() {
        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId(CLIENTID)
                .setServerToken(SERVERTOKEN)
                .build();

        return new ServerTokenSession(config);

    }
}

/*

package org.softwareag.hackthon.service;

import com.uber.sdk.rides.client.model.Product;
import com.uber.sdk.rides.client.model.Ride;
import com.uber.sdk.rides.client.model.RideRequestParameters;

import org.springframework.stereotype.Service;

import java.util.List;

import retrofit2.Response;


@Service
public class FareEstimateService {

    public void requestRide(float start_latitude ,float stop_longitude ,float end_latitude, float end_longitude){
        RideRequestParameters rideRequestParameters = new RideRequestParameters.Builder().setPickupCoordinates(start_latitude, stop_longitude)
                .setProductId(productId)
                .setDropoffCoordinates(37.49f, -122.41f)
                .build();
        Ride ride = service.requestRide(rideRequestParameters).execute().body();
        String rideId = ride.getRideId();
    }

    // Get a list of products for a specific location in GPS coordinates, example: 37.79f, -122.39f.
    public void productsForspecificLocation() {
        Response<List<Product>> response = service.getProducts(37.79f, -122.39f).execute();
        List<Product> products = response.body();
        String productId = products.get(0).getProductId();
    }
}


*/
