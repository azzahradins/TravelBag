package com.example.travelbag.Model;

public class Destination {
    String cityName, placeName, placeLocation, description, priceNormal, priceHoliday, image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Destination(String cityName, String placeName, String placeLocation, String description, String priceNormal, String priceHoliday, String image) {
        this.cityName = cityName;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.description = description;
        this.priceNormal = priceNormal;
        this.priceHoliday = priceHoliday;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(String priceNormal) {
        this.priceNormal = priceNormal;
    }

    public String getPriceHoliday() {
        return priceHoliday;
    }

    public void setPriceHoliday(String priceHoliday) {
        this.priceHoliday = priceHoliday;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
