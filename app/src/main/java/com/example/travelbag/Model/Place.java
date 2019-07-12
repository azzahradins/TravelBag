package com.example.travelbag.Model;

public class Place {
    String cityImage, cityName;

    public Place(String cityImage, String cityName) {
        this.cityImage = cityImage;
        this.cityName = cityName;
    }

    public String getCityImage() {
        return cityImage;
    }

    public void setCityImage(String cityImage) {
        this.cityImage = cityImage;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
