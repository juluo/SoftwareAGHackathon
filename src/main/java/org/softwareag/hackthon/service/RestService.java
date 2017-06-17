package org.softwareag.hackthon.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softwareag.hackthon.uber.FareEstimateService;
import org.softwareag.hackthon.uber.ServerToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by rvignesh on 6/17/2017.
 */
@Service
public class RestService {

    private final ServerToken serverToken;

    @Autowired
    public RestService(ServerToken serverToken){
        this.serverToken = serverToken;
    }

    final static Logger LOG = LoggerFactory.getLogger(RestService.class);

    @Autowired
    private ObjectMapper objectMapper;

    // HTTP GET request
    public String sendGet(String url ,boolean authenticationRequired) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "CHROME");
        if(authenticationRequired) {
            String server_token = "x-mBrc32JTbPYIjlcvAWTaMw0Ea0mdxEwYr4F6eE";
            con.setRequestProperty("Authorization", "Token "+server_token);
        }
        int responseCode = con.getResponseCode();
        LOG.info("\nSending 'GET' request to URL : " + url);
        LOG.info("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        LOG.info(response.toString());

        return response.toString();

    }


    public <T> T bindJsonToObj(String request, Class<T> clazz) {
        LOG.info("Request Body --> " + request);
        try {
            T t = objectMapper.readValue(request, clazz);
            return t;
        } catch (IOException e) {
            throw new HttpMessageNotReadableException("IOException", e);
        }
    }
}
