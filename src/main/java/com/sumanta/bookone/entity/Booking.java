package com.sumanta.bookone.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyName;
    private String propertyId;
    private String bookingId;

    private LocalDate arrival;
    private LocalDate departure;
    private LocalDate bookingDate;

    private String status;
    private int noOfRooms;
    private int noOfNights;
    private Boolean isReported;


    public Booking() {
    }


    public Long getId() {
        return id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public Boolean getIsReported() {
        return isReported;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setArrival(LocalDate arrival) {
        this.arrival = arrival;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public void setNoOfNights(int noOfNights) {
        this.noOfNights = noOfNights;
    }

    public void setIsReported(Boolean isReported) {
        this.isReported = isReported;
    }
}