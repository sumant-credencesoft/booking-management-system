package com.sumanta.bookone.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto{
    private  Long Id;
    private  String propertyName;
    private String propertyId;
    private String bookingId;

    private LocalDate arrival;
    private LocalDate departure;
    private LocalDate bookingDate;
    private String status;
    private int noOfRooms;
    private int noOfNights;
    private Boolean isReported;

    public BookingDto(Object id, String propertyName, String propertyId, String bookingId, String arrival, String departure,  LocalDate bookingDate, String status, int noOfRooms, int noOfNights, Boolean isReported) {
    }
}
