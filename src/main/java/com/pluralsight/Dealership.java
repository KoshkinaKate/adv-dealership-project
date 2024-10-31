package com.pluralsight;
//information about dealership and a list of Vehicles objects (inventory);
import java.util.List;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList <Vehicle> inventory; //storing collection of vehicles

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>(); // available outside of this class
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> price = new ArrayList<>(); //List of Vehicle objects; temporary hold data specific to this search
        for (Vehicle vehicle : inventory) { // iterates over each Vehicle object in inventory.
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max ){ //get coming from Vehicle class
                price.add(vehicle); //add to the price list
            }
        }
        return price;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> makeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                makeModel.add(vehicle);
            }
        }
        return makeModel;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> year = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max ){
                year.add(vehicle);
            }
        }
        return year;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> colorCar = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                colorCar.add(vehicle);
            }
        }
        return colorCar;
    }

    public List<Vehicle> getVehiclesByMileage(int min,int max){
        List<Vehicle> mileage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max ){
                mileage.add(vehicle);
            }
        }
        return mileage;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List<Vehicle> type = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                type.add(vehicle);
            }
        }
        return type;

    }
    public List<Vehicle> getAllVehicles( ){
        return inventory;

    }
    //Object Vehicle is named vehicle (placeholder)
    public void addVehicle(Vehicle vehicle){
        if (vehicle != null) { //check if it is not null
            inventory.add(vehicle);
        }

    }
    public void removeVehicle( Vehicle vehicle){
        if (vehicle != null) {
            inventory.remove(vehicle);
        }
    }
    //helper for removeVehicle
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle; // if the vehicle is VIN matches
            }
        }
        return null; // if VIN does not match
    }
}
