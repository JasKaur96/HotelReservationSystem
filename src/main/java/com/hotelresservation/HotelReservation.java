package com.hotelresservation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservation {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

    //Adding hotel.
    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public void getHotelDetails(){
        Hotel hotel1 = new Hotel("LakeWood", 110, 90);
        Hotel  hotel2 = new Hotel("BridgeWood", 150, 50);
        Hotel  hotel3 = new Hotel("RidgeWood" , 220, 150);
        hotelList.add(hotel1);
        hotelList.add(hotel2);
        hotelList.add(hotel3);
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(ArrayList<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    //To count number of days from the given range of date.
    public int countNoOfDays(String firstDate,String lastDate) {
        LocalDate startDate = LocalDate.parse(firstDate);
        LocalDate endDate = LocalDate.parse(lastDate);
        return  (int) ChronoUnit.DAYS.between(startDate,endDate);
    }

    //To get the cheapest hotel.
    public Hotel getCheapestHotel(int countNoOfDays){
        hotelList.stream().map(r -> {r.setRate(countNoOfDays); return r.getRate(); }).collect(Collectors.toList());
        Hotel minRate = hotelList.stream()
                .min(Comparator.comparing(Hotel::getWeekDayRates))
                .orElseThrow(NoSuchElementException::new);
        return minRate;
    }

    public static void main(String[] args) {
        System.out.println("*****Welcome to the Hotel Reservation.*****");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.getHotelDetails();
    }
}
