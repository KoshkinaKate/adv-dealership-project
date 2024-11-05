package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    private static final String FILE_PATH = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            if (contract instanceof SalesContract) {
                //SALE
                SalesContract salesContract = (SalesContract) contract;
                writer.write("SALE," + salesContract.getDate() + "," + salesContract.getCustomerName() + "," +
                        salesContract.getCustomerEmail() + "," + salesContract.getVehicle().getVin() + "," +
                        salesContract.getVehicle().getYear() + "," + salesContract.getVehicle().getMake() + "," +
                        salesContract.getVehicle().getModel() + "," + salesContract.getVehicle().getVehicleType() + "," +
                        salesContract.getVehicle().getColor() + "," + salesContract.getVehicle().getOdometer() + "," +
                        salesContract.getVehicle().getPrice() + "," + salesContract.getSalesTaxAmount() + "," +
                        salesContract.getRecordingFee() + "," + salesContract.getProcessingFee() + "," +
                        salesContract.getTotalPrice() + "," + (salesContract.isFinanceOption() ? "YES" : "NO") + "," +
                        salesContract.getMonthlyPayment());
           
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
