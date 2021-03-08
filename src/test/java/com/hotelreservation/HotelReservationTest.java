package com.hotelreservation;

import com.hotelresservation.Hotel;
import com.hotelresservation.HotelReservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HotelReservationTest<result> {

      @Test
      public void givenHotel_ShouldReturnTrue() {
          HotelReservation hotelReservation = new HotelReservation();
          Hotel hotel = new Hotel("Lakewood",110,90);
          hotelReservation.addHotel(hotel);
          List hotelList = hotelReservation.getHotelList();
          System.out.println(hotelList);
          Assertions.assertTrue(hotelList.contains(hotel));
      }

      @Test
      public void givenHotels_shouldReturnCheapestHotel(){
          HotelReservation hotelReservation = new HotelReservation();
          Hotel Lakewood = new Hotel("Lakewood",110,90);
          Hotel Bridgewood = new Hotel("Bridgewood",160,50);
          Hotel RidgeWood = new Hotel("Ridgewood",220,150);
          hotelReservation.addHotel(Lakewood);
          hotelReservation.addHotel(Bridgewood);
          hotelReservation.addHotel(RidgeWood);
          List hotelList = hotelReservation.getHotelList();
          System.out.println(hotelList);
          long days = hotelReservation.noOfWeekEnds("10-09-2021","12-09-2021");
          Hotel result = hotelReservation.getCheapestHotel((int) days);
          Assertions.assertTrue(hotelList.contains(result));
      }

    @Test
    public void givenDateRange_shouldReturnCheapestHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        Hotel Lakewood = new Hotel("Lakewood",110,90);
        Hotel Bridgewood = new Hotel("Bridgewood",160,50);
        Hotel RidgeWood = new Hotel("Ridgewood",220,150);
        hotelReservation.addHotel(Lakewood);
        hotelReservation.addHotel(Bridgewood);
        hotelReservation.addHotel(RidgeWood);
        List hotelList = hotelReservation.getHotelList();
        System.out.println(hotelList);
        long days = hotelReservation.noOfWeekDays("2020-09-10","2020-09-12");
        Hotel result = hotelReservation.getCheapestHotel((int) days);
        Assertions.assertTrue(hotelList.contains(result));
    }

    @Test
    public void givenDateRange_basisOfWeekDayWeekEnd_shouldReturnCheapestHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        Hotel Lakewood = new Hotel("Lakewood",110,90);
        Hotel Bridgewood = new Hotel("Bridgewood",160,50);
        Hotel RidgeWood = new Hotel("Ridgewood",220,150);
        hotelReservation.addHotel(Lakewood);
        hotelReservation.addHotel(Bridgewood);
        hotelReservation.addHotel(RidgeWood);
        List hotelList = hotelReservation.getHotelList();
        Hotel result = hotelReservation.getCheapestHotel("2020-09-11","2020-09-12");
        Assertions.assertTrue(hotelList.contains(result));
    }

    @Test
    public void givenDates_basisOfWeekDayWeekEnd_shouldReturnCheapestHotel(){
        HotelReservation hotelReservation = new HotelReservation();
        Hotel Lakewood = new Hotel("Lakewood",110,90,3);
        Hotel Bridgewood = new Hotel("Bridgewood",160,50,4);
        Hotel RidgeWood = new Hotel("Ridgewood",220,150,5);
        hotelReservation.addHotel(Lakewood);
        hotelReservation.addHotel(Bridgewood);
        hotelReservation.addHotel(RidgeWood);
        List hotelList = hotelReservation.getHotelList();
        Hotel result = hotelReservation.getCheapestHotel("2020-09-11","2020-09-12");
        Assertions.assertTrue(hotelList.contains(result));
    }


}
