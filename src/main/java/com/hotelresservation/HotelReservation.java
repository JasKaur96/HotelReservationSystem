package com.hotelresservation;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelReservation {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
    static long totalDays,totalWeekDays,totalWeekEndDays;

    //Adding hotel.
    public void addHotel(String hotelName, int rate){
        Hotel hotel = new Hotel(hotelName,rate);
        hotelList.add(hotel);
    }

    public void getHotelDetails(){
        String hotel1 = "LakeWood";
        String hotel2 = "BridgeWood";
        String hotel3 = "RidgeWood";
        List LakeWoodRate = Arrays.asList(110,80);
        List BridgeWoodRate = Arrays.asList(160,110);
        List RidgeWoodRate = Arrays.asList(220,100);

        System.out.println("\nEnter Number of Days you want to book the hotelroom :");
        int noOfDays = sc.nextInt();
        addHotel(hotel1, (Integer) LakeWoodRate.get(0) * noOfDays);
        addHotel(hotel2, (Integer) BridgeWoodRate.get(0) * noOfDays);
        addHotel(hotel3, (Integer) RidgeWoodRate.get(0) * noOfDays);
    }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

//    public ArrayList<Hotel> setHotelList(){
//       this.hotelList = hotelList;
//    }
    public Hotel getCheapestHotel(){
        Hotel minRate = hotelList.stream().min(Comparator.comparing(Hotel::getWeekDayRates))
                .orElseThrow(NoSuchElementException::new);
        return minRate;
    }

    public void getInput(String date1,String date2) {
        LocalDate[] localDate = new LocalDate[2];

        //Split the string to get the dates
        String[] dates = date1.split(":|,");
        String[] dates2 = date2.split(":|,");
        date1 = dates[0];
        date2= dates2[0];
        for(int iteration = 0; iteration<1 ; iteration++) {
            //Convert dates to standard format
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(dates[iteration], formatter);
                localDate[iteration-1] = date;
            }
            catch(DateTimeException exception) {
                System.out.println("Invalid Date Entry");
                exception.printStackTrace();

            }
        }
        LocalDate start = localDate[0];
        LocalDate end = localDate[1];
        totalDays = ChronoUnit.DAYS.between(start, end);
        totalDays = totalDays + 1;
        totalWeekEndDays = getTotalWeekEndDays(start, end);
        totalWeekDays = totalDays - totalWeekEndDays;
        System.out.println(totalWeekDays);
    }

    public int getTotalWeekEndDays(LocalDate start, LocalDate end) {
        long weekEndDays = 0;
        LocalDate next = start.minusDays(1);
        //iterate from start date to end date
        while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            if(next.getDayOfWeek().toString().equals("SATURDAY") || next.getDayOfWeek().toString().equals("SUNDAY")) {
                totalWeekEndDays++;
            }
        }
        return (int)totalWeekEndDays;
    }

    public static void main(String[] args) {
        System.out.println("*****Welcome to the Hotel Reservation.*****");
        HotelReservation hotelReservation = new HotelReservation();
//        Hotel hotel = new Hotel("Lakewood",110);
        hotelReservation.getHotelDetails();
        System.out.println(hotelReservation.getCheapestHotel());

         String date1= "10/02/2021";
         String date2="11/03/2021";

         hotelReservation.getInput(date1, date2);
//
//
//        sc.close();

    }
}
