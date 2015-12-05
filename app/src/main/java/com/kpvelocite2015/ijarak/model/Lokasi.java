package com.kpvelocite2015.ijarak.model;

import com.google.gson.annotations.Expose;

public class Lokasi {

    @Expose
    private Double longitude;
    @Expose
    private Double latitude;

    /**
     * @return The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}