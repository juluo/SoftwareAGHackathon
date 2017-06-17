package org.softwareag.hackthon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    final static Logger LOG = LoggerFactory.getLogger(RequestController.class);


}
