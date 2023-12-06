package com.covidtracker.covidtracker.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class CoronVirusDataService {

//    service for fetching COVID data
    private static String VIRUS_DATA_URL = "https://github.com/CSSEGISandData/COVID-19/blob/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    //    Data just for testing purposes
    private List<LocationStats> allStats = new ArrayList<>();


//    method to return all statistics
    public List<LocationStats> getAllStats() {
        return allStats;
    }


//    method to fetch data
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
//        receives the client request

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();


        HttpResponse<String> httpResponse = (HttpResponse<String>) client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse);




    }

}
