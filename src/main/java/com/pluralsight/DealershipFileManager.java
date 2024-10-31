package com.pluralsight;
//handles reading writing for csv file
import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        String line;
        Dealership dealership = null;// Placeholder for Dealership object
        int counter = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader("dealership.csv"));
            while ((line = br.readLine()) !=null){
                //dealership information
                if (counter < 1){
                    String [] dealerParts = line.split("\\|");
                    String name = dealerParts[0];
                    String address = dealerParts[1];
                    String phoneNumber = dealerParts[2];
                    dealership = new Dealership(name, address, phoneNumber);
                } else{
                    //vehicle information
                    String [] vehicleParts = line.split("\\|");
                    int vin = Integer.parseInt(vehicleParts[0]);
                    int year = Integer.parseInt(vehicleParts[1]);
                    String make = vehicleParts[2];
                    String model = vehicleParts[3];
                    String vehicleType = vehicleParts[4];
                    String color = vehicleParts[5];
                    int odometer = Integer.parseInt(vehicleParts[6]);
                    double price = Double.parseDouble(vehicleParts[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType,color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
                counter ++;

            }
            br.close();
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return dealership;
    }



    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"))) { // Overwrite because handles add/remove vehicles
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine(); //in order to keep dealership in csv.
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
        //try/catch close writer automatically
    }

}