package org.softwareag.hackthon.bookTickets.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rvignesh on 6/16/2017.
 */
@RestController
public class RequestController {

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String doProcess(){
        return "Working";
    }

}
