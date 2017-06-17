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

import javax.annotation.PostConstruct;

import retrofit2.Response;

/**
 * Created by rvignesh on 6/17/2017.
 */
@Configuration
public class ServerToken {

    private final String CLIENTID = "IaftrSzT_KSshKwoz91hIt3ynUN-FgtO";
    private final String SERVERTOKEN = "x-mBrc32JTbPYIjlcvAWTaMw0Ea0mdxEwYr4F6eE";

    /*@Bean
    public ServerTokenSession getServerTokenSession() {
        SessionConfiguration config = new SessionConfiguration.Builder()
                .setClientId(CLIENTID)
                .setServerToken(SERVERTOKEN)
                .build();

        return new ServerTokenSession(config);

    }*/
}
