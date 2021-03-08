package com.hotelresservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HotelReservation {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    static long totalDays,totalWeekDays,totalWeekEndDays;

    //Adding hotel.
    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public void getHotelDetails(){

        Hotel hotel1 = new Hotel("Lakewood",110,90,80,80,3);
        Hotel hotel2 = new Hotel("Bridgewood",150,50,110,50,4);
        Hotel hotel3 = new Hotel("Ridgewood",220,150,100,40,5);
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
    public long noOfWeekDays(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        DayOfWeek start = startDate.getDayOfWeek();
        DayOfWeek end = endDate.getDayOfWeek();
        totalDays = ChronoUnit.DAYS.between(startDate, endDate);
        totalDays = totalDays + 1;
        totalWeekEndDays = getTotalWeekEndDays(startDate, endDate);
        totalWeekDays = totalDays - totalWeekEndDays;
        System.out.println(totalWeekDays);
        return totalWeekDays;
    }

    public long noOfWeekEnds(String date1, String date2) {
        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);
        long weekEndDays = 0;
        LocalDate next = startDate.minusDays(1);
        //iterate from start date to end date
        while ((next = next.plusDays(1)).isBefore(endDate.plusDays(1))) {
            if(next.getDayOfWeek().toString().equals("SATURDAY") || next.getDayOfWeek().toString().equals("SUNDAY")) {
                totalWeekEndDays++;
            }
        }
        return (int)totalWeekEndDays;
    }

    public int getTotalWeekEndDays(LocalDate start, LocalDate end) {
        long weekEndDays = 0;
        LocalDate next = start.minusDays(1);
        //iterate from start date to end date
        long totalWeekEndDays = 0;
        while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            if(next.getDayOfWeek().toString().equals("SATURDAY") || next.getDayOfWeek().toString().equals("SUNDAY")) {
                totalWeekEndDays++;
            }
        }
        return (int)totalWeekEndDays;
    }

    //To get the cheapest hotel.
    public Hotel getCheapestHotel(String date1, String date2){
        totalWeekDays = noOfWeekDays(date1,date2);
        totalWeekEndDays = noOfWeekEnds(date1,date2);
        hotelList.stream().map(r -> {
            r.setRewardRates(totalWeekDays,totalWeekEndDays);
            return r.getRewardRates();
        }).collect(Collectors.toList());
        Hotel minRate = hotelList.stream()
                .min(Comparator.comparing(Hotel::getRewardRates))
                .orElseThrow(NoSuchElementException::new);
        return minRate;
    }
    //Cheap best rated cheap hotel.
    public Hotel getBestCheapHotel(String date1, String date2){
        Hotel minRate = getCheapestHotel(date1,date2);
        int cheapestRate = minRate.getRewardRates();
        Predicate<Hotel> minPrice = rate -> rate.getRewardRates()==cheapestRate;
        List<Hotel> minPriceHotel = hotelList.stream().
                filter(minPrice).collect(Collectors.toList());
        Hotel maxRatings = minPriceHotel.stream().max(Comparator.comparing(Hotel::getRatings))
                .orElseThrow(NoSuchElementException::new);
        return maxRatings;
    }
    //to get best rated hotel.
    public Hotel getBestRatedHotel(String date1, String date2){
        Hotel maxRatings = hotelList.stream().max(Comparator.comparing(Hotel::getRatings))
                .orElseThrow(NoSuchElementException::new);
        return maxRatings;
    }

    public static void main(String[] args) {
        System.out.println("*****Welcome to the Hotel Reservation.*****");
        HotelReservation hotelReservation = new HotelReservation();

    }
}
