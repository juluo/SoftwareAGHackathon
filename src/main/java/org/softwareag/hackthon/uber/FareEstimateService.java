package org.softwareag.hackthon.uber;

import com.uber.sdk.rides.client.model.Product;
import com.uber.sdk.rides.client.model.Ride;
import com.uber.sdk.rides.client.model.RideRequestParameters;

import org.springframework.stereotype.Service;

import java.util.List;

import retrofit2.Response;

/**
 * Created by rvignesh on 6/17/2017.
 */
@Service
public class FareEstimateService {

    String url = "https://api.uber.com/v1.2/estimates/price?start_latitude=<STARTLAT>&start_longitude=-<STARTLONG>&end_latitude=<ENDLAT>&end_longitude=<ENDLONG>";


    public void getFareEstimate(float start_latitude, float stop_longitude, float end_latitude, float end_longitude) {


    }


}
