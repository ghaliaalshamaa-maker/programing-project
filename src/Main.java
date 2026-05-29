public class Main {
    public static void main(String[] args) {
        VehicleManager vehicleManager = new VehicleManager();
        

        System.out.println("--- 1. Testing Vehicle Insertion ---");
       
        Car car = new Car("Damascus-111", "Kia", "bmw", 1.554, true, "Gasoline", true,5000);
        Motorcycle moto = new Motorcycle("Aleppo-222", "Suzuki", "as", 8.2, true,399,false);
        
        Truck truck = new Truck("Homs", "Volvo","sa", 4.0, false, 20.0, true);

        vehicleManager.addVehicle(car);
        vehicleManager.addVehicle(moto);
        vehicleManager.addVehicle(truck);

        System.out.println("\n--- 2. Testing Available Vehicles Filter ---");
        
        vehicleManager.displayAvailable();

        System.out.println("\n--- 3. Testing Customers Insertion (With Objects) ---");
       
        
        Date birthDay = new Date(15, 8, 2004);

       



        System.out.println("\n--- 4. Testing Vehicle Search ---");
        String searchPlate = "Damascus-111";
        Vehicle foundVehicle = vehicleManager.searchVehicle(searchPlate);
        if (foundVehicle != null) {
            System.out.println("-> [FOUND] " + foundVehicle);
        } else {
            System.out.println("-> [NOT FOUND] Vehicle not found.");
        }

        System.out.println("\n--- 5. Testing Vehicle Deletion ---");
     
        vehicleManager.deleteVehicle("Homs-333");
        vehicleManager.display();
    
    }
}
