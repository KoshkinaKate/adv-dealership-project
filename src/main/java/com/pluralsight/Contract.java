package com.pluralsight;

import java.time.LocalDate;

//hold information common to all contracts - parent + abstract
public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle; // instance of Vehicle object with all data
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, Vehicle vehicle) {
        this.date = LocalDate.now().toString();
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();


    @Override
    public String toString() {
        return "Date: " + date;
    }
}
