package com.hotelresservation;

import java.util.Scanner;

public class Hotel {
    public static Hotel maxRatings;
    public String hotelName;
    public int weekDayRates;
    public int weekEndRates;
    public int rates, rewardRates,regularRates;
    public int ratings;
    public long rewardWeekDayRates, rewardWeekEndRates,regularWeekDayRates,regularWeekEndRates;
    public String customerType;
    public Scanner sc = new Scanner(System.in);

    public Hotel(String hotelName, int weekDayRates, int weekEndRates,int rewardWeekDayRates,int rewardWeekEndRates, int ratings) {
        this.hotelName = hotelName;
        this.weekDayRates = weekDayRates;
        this.rewardWeekDayRates = rewardWeekDayRates;
        this.rewardWeekEndRates = rewardWeekEndRates;
        this.regularWeekDayRates = regularWeekDayRates;
        this.regularWeekEndRates = regularWeekEndRates;
        this.ratings = ratings;
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
    public int getWeekEndRates(){
        return weekEndRates;
    }

    public void setWeekEndRates(int weekEndRates){
        this.weekEndRates = weekEndRates;
    }

    public int getRate(){
        return weekDayRates + weekEndRates;
    }
    public void setRate(int noOfWeekDays, int noOfWeekEnd){
        this.weekDayRates = noOfWeekDays + noOfWeekEnd ;
        this.weekEndRates = noOfWeekDays + noOfWeekEnd;
        this.rewardRates = weekDayRates + weekEndRates;
    }

    public void setRewardRates(long noOfWeekDays, long noOfWeekEnd) {
        this.rewardWeekDayRates = rewardWeekDayRates * noOfWeekDays ;
        this.rewardWeekEndRates = rewardWeekEndRates * noOfWeekEnd;
        this.rewardRates = (int) (rewardWeekDayRates + rewardWeekEndRates);
    }
    public int getRewardRates(){
        return rewardRates;
    }

    public void setRegularRates(long noOfWeekDays, long noOfWeekEnd) {
        this.regularWeekDayRates = regularWeekDayRates * noOfWeekDays ;
        this.rewardWeekEndRates = regularWeekEndRates * noOfWeekEnd;
        this.rewardRates = (int) (regularWeekDayRates + regularWeekEndRates);
    }
    public int getRegularRates(){
        return regularRates;
    }

    public int getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        String hotel = "Hotel : " + this.getHotelName() +"\nWeekDayRate : " +this.getWeekDayRates()+"\nWeekEndRate : " +this.getWeekEndRates();
        return hotel;
    }

    public void add(String lakeWood, int i) {
    }

    public void setRate(long totalWeekDays, long totalWeekEndDays) {
    }
}
