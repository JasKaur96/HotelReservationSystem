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
        String hotel1 = "LakeWood";
        String hotel2 = "BridgeWood";
        String hotel3 = "RidgeWood";
        List LakeWoodRate = Arrays.asList(110,80);
        List BridgeWoodRate = Arrays.asList(160,110);
        List RidgeWoodRate = Arrays.asList(220,100);

    }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }
    
    //To count number of days from the given range of date.
    public int countNoOfDays(String start,String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return  (int) ChronoUnit.DAYS.between(startDate,endDate);
    }

    //To get the cheapest hotel.
    public Hotel getCheapestHotel(int countNoOfDays){
        hotelList.stream().map(p -> {p.setRate(countNoOfDays); return p.getRate(); }).collect(Collectors.toList());
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
