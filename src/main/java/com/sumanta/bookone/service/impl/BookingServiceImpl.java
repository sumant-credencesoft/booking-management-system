package com.sumanta.bookone.service.impl;

import com.sumanta.bookone.dto.BookingDto;
import com.sumanta.bookone.entity.Booking;
import com.sumanta.bookone.repository.BookingRepository;
import com.sumanta.bookone.service.BookingService;
import org.springframework.stereotype.Service;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    public BookingServiceImpl(BookingRepository repository) {
        this.repository = repository;

    }
    private BookingDto mapToDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getPropertyName(),
                booking.getPropertyId(),
                booking.getBookingId(),
                booking.getArrival(),
                booking.getDeparture(),
                booking.getBookingDate(),
                booking.getStatus(),
                booking.getNoOfRooms(),
                booking.getNoOfNights(),
                booking.getIsReported()
        );
    }

    private Booking mapToEntity(BookingDto dto) {

        Booking booking = new Booking();

        booking.setPropertyName(dto.getPropertyName());
        booking.setPropertyId(dto.getPropertyId());
        booking.setBookingId(dto.getBookingId());
        booking.setArrival(dto.getArrival());
        booking.setDeparture(dto.getDeparture());
        booking.setBookingDate(dto.getBookingDate());
        booking.setStatus(dto.getStatus());
        booking.setNoOfRooms(dto.getNoOfRooms());
        booking.setNoOfNights(dto.getNoOfNights());
        booking.setIsReported(dto.getIsReported());

        return booking;
    }
    @Override
    public BookingDto save(BookingDto dto) {
        Booking booking = repository.save(mapToEntity(dto));
        return mapToDto(booking);
    }

    @Override
    public List<BookingDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getById(Long id) {
        return repository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(()-> new RuntimeException("Booking not found"));
    }
    @Override
    public BookingDto update(Long id, BookingDto dto){
        Booking booking = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));
        booking.setStatus(dto.getStatus());
        booking.setIsReported(dto.getIsReported());

        return mapToDto(repository.save(booking));

    }
    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
    @Override
    public List<BookingDto> getBetweenDates(LocalDate fromDate, LocalDate toDate){
        return repository.findByBookingDateBetween(fromDate,toDate)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public BookingDto getByBookingId(String bookingId) {
        return mapToDto(repository.findByBookingId(bookingId));
    }
}