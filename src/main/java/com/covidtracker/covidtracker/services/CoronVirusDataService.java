package com.covidtracker.covidtracker.services;

import org.apache.commons.csv.*;
import org.apache.commons.csv.CSVRecord;


import java.io.*;
import java.net.*;
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
//        method to return all the COVID stats
        return allStats;
    }


//    method to fetch data
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
//        receives the client request

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();


        HttpResponse<String> httpResponse = (HttpResponse<String>) client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(httpResponse);

//        replace with a stringbuilder for the output
        StringBuilder csvBodyReader = new StringBuilder(httpResponse.body());

        CSVFormat records = CSVFormat.DEFAULT.withFirstRecordAsHeader();

//        iterable loop to parse the csv data coming back in the CSV record
        for(CSVRecord record: records){
            LocationStats locationStat = new LocationStat();
            locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size() - 1 ));
            int previousDayCases = Integer.parseInt(record.get(record.size() - 2 ));
            locationStat.setLatestTotalCases(latestCases);
            locationStat.setDiffFromToday(latestCases - previousDayCases);
            newStats.add(locationStat);
        }




    }

}
