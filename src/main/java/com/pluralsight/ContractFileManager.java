package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    private static final String FILE_PATH = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) { //will not overwrite
            if (contract instanceof SalesContract) { //if this is true it casts on line 15
                //SALE
                SalesContract salesContract = (SalesContract) contract;
                writer.write("SALE|" + salesContract.getDate() + "|" + salesContract.getCustomerName() + "|" +
                        salesContract.getCustomerEmail() + "|" + salesContract.getVehicle().getVin() + "|" +
                        salesContract.getVehicle().getYear() + "|" + salesContract.getVehicle().getMake() + "|" +
                        salesContract.getVehicle().getModel() + "|" + salesContract.getVehicle().getVehicleType() + "|" +
                        salesContract.getVehicle().getColor() + "|" + salesContract.getVehicle().getOdometer() + "|" +
                        salesContract.getVehicle().getPrice() + "|" + salesContract.getSalesTaxAmount() + "|" +
                        salesContract.getRecordingFee() + "|" + salesContract.getProcessingFee() + "|" +
                        salesContract.getTotalPrice() + "|" + (salesContract.isFinanceOption() ? "YES" : "NO") + "|" +
                        salesContract.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {
                // LEASE
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write("LEASE|" + leaseContract.getDate() + "|" + leaseContract.getCustomerName() + "|" +
                        leaseContract.getCustomerEmail() + "|" + leaseContract.getVehicle().getVin() + "|" +
                        leaseContract.getVehicle().getYear() + "|" + leaseContract.getVehicle().getMake() + "|" +
                        leaseContract.getVehicle().getModel() + "|" + leaseContract.getVehicle().getVehicleType() + "|" +
                        leaseContract.getVehicle().getColor() + "|" + leaseContract.getVehicle().getOdometer() + "|" +
                        leaseContract.getVehicle().getPrice() + "|" + leaseContract.getExpectedEndingValue() + "|" +
                        leaseContract.getLeaseFee() + "|" + leaseContract.getTotalPrice() + "|" +
                        leaseContract.getMonthlyPayment());
            }
            writer.newLine(); //newline after each contact entry
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
