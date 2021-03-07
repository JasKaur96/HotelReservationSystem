package com.hotelresservation;
import java.util.*;

public class HotelReservation {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

    //Adding hotel.
    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }
    //get hotel details.
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

    public static void main(String[] args) {
        System.out.println("*****Welcome to the Hotel Reservation.*****");
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.getHotelDetails();
    }
}
