package com.hotelresservation;

import java.util.Date;
import java.util.Scanner;

public class Hotel {
    public String hotelName;
    public int weekDayRates;
    public int weekEndRates;
    public static String startDate;
    public static String endDate;
    public Scanner sc = new Scanner(System.in);

    public Hotel(String hotelName, int weekDayRates) {
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

//    public int getRate(){
//        return rates;
//    }
//    public void setRate(int rates){
//        this.rates = rates;
//    }

    @Override
    public String toString() {
        String hotel = "Hotel : " + this.getHotelName() +"\nWeekDayRate : " +this.getWeekDayRates();
        return hotel;
    }

    public void getDate(String startDate, String endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void add(String lakeWood, int i) {
    }
}
