package com.hotelresservation;

import java.util.Scanner;

public class Hotel {
    public String hotelName;
    public int weekDayRates;
    public int weekEndRates;
    public int rates;
    public Scanner sc = new Scanner(System.in);

    public Hotel(String hotelName, int weekDayRates, int weekEndRates) {
        this.hotelName = hotelName;
        this.weekDayRates = weekDayRates;
    }

    public String getHotelName(){
        return hotelName;
    }

    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }

    public int getWeekDayRates(){
        return weekDayRates;
    }

    public void setWeekDayRates(int weekDayRates){
        this.weekDayRates = weekDayRates;
    }
    public int getWeekEndRatesDayRates(){
        return weekEndRates;
    }

    public void setWeekEndRatesDayRates(int weekEndRates){
        this.weekEndRates = weekEndRates;
    }

    public int getRate(){
        return weekDayRates + weekEndRates;
    }
    public void setRate(int noOfWeekDays, int noOfWeekEnd){
        this.weekDayRates = noOfWeekDays + noOfWeekEnd ;
        this.weekEndRates = noOfWeekDays + noOfWeekEnd;
        this.rates = weekDayRates + weekEndRates;
    }

    @Override
    public String toString() {
        String hotel = "Hotel : " + this.getHotelName() +"\nWeekDayRate : " +this.getWeekDayRates();
        return hotel;
    }

    public void add(String lakeWood, int i) {
    }

    public void setRate(long totalWeekDays, long totalWeekEndDays) {
    }
}
