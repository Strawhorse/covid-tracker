package com.com.covidtracker.controllers;

import com.com.covidtracker.models.LocationStats;
import com.com.covidtracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronVirusDataService;

    @GetMapping("/")
    public String home(Model model){
//        create a controller
        List<LocationStats> allStats = coronVirusDataService.getAllStats();

        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();

        model.addAttribute("LocationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);

//        create one html form using Thymeleaf to output all the data

        return "home";
    }


}
