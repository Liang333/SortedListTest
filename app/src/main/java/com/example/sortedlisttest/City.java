package com.example.sortedlisttest;

public class City  {
     private int id;
     private String cityName;
     private String firstLetter;

    public City(int id, String cityName, String firstLetter) {
        this.id = id;
        this.cityName = cityName;
        this.firstLetter = firstLetter;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }
}
