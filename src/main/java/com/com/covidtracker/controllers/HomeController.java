package com.com.covidtracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
//     creating a web app to control everything

//    loading the service
//    @Autowired
//    CoronVirusDataService coronVirusDataService;
//
//    @GetMapping("/")
//    public String home(Model model){
////        create a controller
//        List<LocationStats> allStats = coronVirusDataService.getAllStats();
//
////        create one html form using Thymeleaf to output all the data
//
//        return null;
//    }


}
