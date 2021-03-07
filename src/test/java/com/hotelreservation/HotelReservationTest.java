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
          Hotel hotel = new Hotel("Lakewood",110);
          hotelReservation.addHotel(hotel);
          List hotelList = hotelReservation.getHotelList();
          System.out.println(hotelList);
          Assertions.assertTrue(hotelList.contains(hotel));
      }
}
