package com.sumanta.bookone.controller;

import com.sumanta.bookone.dto.BookingDto;
import com.sumanta.bookone.repository.BookingRepository;
import com.sumanta.bookone.service.BookingService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService service;
    public BookingController(BookingService service){
        this.service = service;

    }

    @PostMapping
    public BookingDto create(@RequestBody BookingDto dto){
        return service.save(dto);
    }
    @GetMapping
    public List<BookingDto> getAll() {
        return service.getAll();

    }
    @GetMapping("/{id}")
    public BookingDto getById(@PathVariable Long id){
        return service.getById(id);

    }
    @PutMapping("/{id}")
    public BookingDto update(@PathVariable Long id, @RequestBody BookingDto dto){
        return service.update(id,dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/between")
    public List<BookingDto> getBetween(
            @RequestParam LocalDate fromDate,
            @RequestParam LocalDate toDate) {
        return service.getBetweenDates(fromDate, toDate);
    }

    @GetMapping("/external/{bookingId}")
    public BookingDto getByBookingId(@PathVariable String bookingId) {
        return service.getByBookingId(bookingId);
    }

}
