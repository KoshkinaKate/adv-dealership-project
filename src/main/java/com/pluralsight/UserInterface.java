package com.pluralsight;
//menu for a user
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership; //hold Dealership object
    private DealershipFileManager fileManager = new DealershipFileManager(); //an instance of DFM that assigned to the fileManager
    private ContractFileManager contractFileManager = new ContractFileManager();
    Scanner scanner = new Scanner(System.in);

    //empty constructor
    public UserInterface() {
    }

    public void display(){

        init(); // the dealership data
        System.out.println("Welcome to " + dealership.getName() + "!");
        System.out.println("Address: " + dealership.getAddress());
        System.out.println("Phone: " + dealership.getPhone());
        while(true) {
            int option = helperDisplay();
            switch(option){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSellVehicleRequest();
                    break;
                case 11:
                    processLeaseVehicleRequest();
                    break;
                case 99:
                    System.out.println("Thank you for visiting our Dealership! ");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

    }

    public int helperDisplay(){
        System.out.println("Search Menu: ");
        System.out.println("1- Find vehicles within a price range ");
        System.out.println("2- Find vehicles by make/model ");
        System.out.println("3- Find vehicles by year ");
        System.out.println("4- Find vehicles by color ");
        System.out.println("5- Find vehicles by miles range ");
        System.out.println("6- Find vehicles by type (car, truck, SUV, van) ");
        System.out.println("7- All vehicles ");
        System.out.println("8- Add a vehicle ");
        System.out.println("9- Remove a vehicle ");
        System.out.println("10- Sell a vehicle "); // SALE
        System.out.println("11- Lease a vehicle "); // LEASE
        System.out.println("99-  Exit");

        System.out.println("========================");
        System.out.println("Please enter an option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;


    }
    //method to Loading dealership object
    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();

    }
    //display a list of vehicles
    private void displayVehicles(List<Vehicle> vehicle){
        for (Vehicle vehicle1 : vehicle) {
            System.out.println(vehicle1);
        }


    }

    public void processGetByPriceRequest() {
        System.out.println("Enter minimum price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        //calling method from dealership
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    public void processGetByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }
    public void processGetByYearRequest() {
        System.out.println("Enter minimum year:");
        int minYear = scanner.nextInt();
        System.out.println("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }
    public void processGetByColorRequest() {
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }
    public void processGetByMileageRequest() {
        System.out.println("Enter minimum mileages:");
        int minMileages = scanner.nextInt();
        System.out.println("Enter maximum mileages: ");
        int maxMileages = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileages, maxMileages);
        displayVehicles(vehicles);
    }
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter vehicle type (car, truck, SUV, van) : ");
        String type = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);

    }
    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());

    }
    public void processAddVehicleRequest() {
        System.out.println("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter type (car, truck, SUV, van) : ");
        String type = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter mileages: ");
        int odometer = scanner.nextInt();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        fileManager.saveDealership(dealership);
        System.out.println("Your vehicle was added!");


    }
    public void processRemoveVehicleRequest() {
        System.out.println("Enter VIN to remove a vehicle: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = dealership.getVehicleByVin(vin);
        if (vehicle != null) {
            //calling method from dealership
            dealership.removeVehicle(vehicle);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle with VIN " + vin + " was removed successfully.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }

    }

    public void processSellVehicleRequest(){

    }

    public void processLeaseVehicleRequest(){

    }
}