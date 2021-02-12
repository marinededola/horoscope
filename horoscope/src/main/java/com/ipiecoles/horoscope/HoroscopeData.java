package com.ipiecoles.horoscope;

//Donnee entre service
public class HoroscopeData {

    public HoroscopeData() {
    }

    private String signe;

    public HoroscopeData(String signe) {
        this.signe = signe;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }
}
