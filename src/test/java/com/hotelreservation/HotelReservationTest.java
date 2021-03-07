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
          Hotel hotel = new Hotel("LakeWood",100);
          List hotelList = hotelReservation.getHotelList();
          Assertions.assertTrue(hotelList.contains(hotel));
      }

    @Test
    public void givenNoOfDays_ShouldReturnCheapestHotel() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel = new Hotel("LakeWood",100);
        List hotelList = hotelReservation.getHotelList();
        String expectedResult = "LakeWood";
        Assertions.assertTrue(hotelList.contains(hotel));
    }
}
