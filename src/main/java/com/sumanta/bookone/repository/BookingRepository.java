package com.sumanta.bookone.repository;

import com.sumanta.bookone.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByBookingDateBetween(LocalDate fromDate, LocalDate toDate);

    Booking findByBookingId(String bookingId);
}