package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05; // - 5%
    private static final double RECORDING_FEE = 100; //static - can be accessed directly from a class
    private static final double PROCESSING_FEE_UNDER_10000 = 295; //final - can not be changed
    private static final double PROCESSING_FEE_OVER_10000 = 495;

    private boolean financeOption; // True if finance
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;

    //Constructor
    public SalesContract(String customerName, String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(customerName, customerEmail, vehicle);
        this.financeOption = financeOption;

        // values based on fixed terms above(to later use it)
        this.salesTaxAmount = getVehicle().getPrice() * SALES_TAX_RATE; //getting info about car * tax rate
        this.recordingFee = RECORDING_FEE;
        if (getVehicle().getPrice() < 10000) {
            this.processingFee = PROCESSING_FEE_UNDER_10000;
        } else {
            this.processingFee = PROCESSING_FEE_OVER_10000;
        }

    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }
    //total price
    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    //monthly payment if financed
    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;

        if (financeOption) {
            if (getVehicle().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }
            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) /
                    (Math.pow(1 + interestRate, numberOfPayments) - 1);

            monthlyPayment = Math.round(monthlyPayment * 100.0) / 100.0; //round to 2 decimal places
            return monthlyPayment;
        } else {
            return 0.0; // if no financing = monthly payment is zero
        }
    }

    // to String display contract details
    @Override
    public String toString() {
        return "Sales Contract | " +
                "Date: " + getDate() +
                ", Customer: " + getCustomerName() +
                ", Email: " + getCustomerEmail() +
                ", Vehicle VIN: " + getVehicle().getVin() +
                ", Total Price: $" + getTotalPrice() +
                ", Monthly Payment: $" + getMonthlyPayment() +
                ", Finance Option: " + (financeOption ? "Yes" : "No");
    }
}
