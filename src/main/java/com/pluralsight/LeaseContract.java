package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double EXPECTED_ENDING_VALUE = 0.50; // 50% of the original price
    private static final double LEASE_FEE = 0.07; // 7% of the original price

    private double expectedEndingValue;
    private double leaseFee;

    // Constructor
    public LeaseContract(String customerName, String customerEmail, Vehicle vehicle) {
        super(customerName, customerEmail, vehicle);
        //calculation of values
        this.expectedEndingValue = getVehicle().getPrice() * EXPECTED_ENDING_VALUE;
        this.leaseFee = getVehicle().getPrice() * LEASE_FEE;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicle().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100); //rounds to 2 decimal
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}