package com.sumanta.bookone.service;

import com.sumanta.bookone.dto.BookingDto;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;


import java.time.LocalDate;
import java.util.List;


public interface BookingService {
    BookingDto save(BookingDto dto);
    List<BookingDto> getAll();
    BookingDto getById(Long id) throws ConfigDataResourceNotFoundException;

    BookingDto update(Long id , BookingDto dto);
    BookingDto getByBookingId(String bookingId);

    void delete(Long id);
    List<BookingDto> getBetweenDates(LocalDate fromDate, LocalDate toDate);

}
