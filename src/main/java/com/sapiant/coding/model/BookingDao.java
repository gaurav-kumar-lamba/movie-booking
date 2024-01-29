package com.sapiant.coding.model;

import com.sapiant.coding.entity.Bookings;
import com.sapiant.coding.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingDao {
    @Autowired
    BookingsRepository theBookingsRepository;

    //	Get the available seat for the movie
    public Bookings getAvailableSeat(long showID) {
        return theBookingsRepository.getOne(showID);
    }

    //	Book the seat
    public Bookings bookTheSeat(Bookings book) {
        return theBookingsRepository.save(book);
    }
}
