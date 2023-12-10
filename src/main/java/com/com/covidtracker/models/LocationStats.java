package com.com.covidtracker.models;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPreviousDay;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public int getDiffFromPreviousDay() {
        return diffFromPreviousDay;
    }

    public void setDiffFromPreviousDay(int diffFromPreviousDay) {
        this.diffFromPreviousDay = diffFromPreviousDay;
    }

    public void setLatestTotalCases(int latestCases) {
    }

    public void setDiffFromToday(int i) {
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                ", diffFromPreviousDay=" + diffFromPreviousDay +
                '}';
    }
}
