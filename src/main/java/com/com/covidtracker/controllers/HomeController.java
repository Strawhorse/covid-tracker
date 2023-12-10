package com.com.covidtracker.controllers;

import com.com.covidtracker.models.LocationStats;
import com.com.covidtracker.services.CoronVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
//     creating a web app to control everything

//    loading the service
    @Autowired
    CoronVirusDataService coronVirusDataService;

    @GetMapping("/")
    public String home(Model model){
//        create a controller
        List<LocationStats> allStats = coronVirusDataService.getAllStats();

//        create one html form using Thymeleaf to output all the data

        return null;
    }


}
