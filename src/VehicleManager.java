import java.util.ArrayList;
public class VehicleManager {
    private ArrayList<Vehicle> vehiclesList;

    public VehicleManager() {
        this.vehiclesList=new ArrayList<>();
    }

    public void addVehicle(Vehicle newVehicle){
        for(Vehicle v:vehiclesList){
            if(v.getPliatNumber().equalsIgnoreCase(newVehicle.getPliatNumber())){
                System.out.println("[Error]"+newVehicle.getPliatNumber()+"already exists!");
                return;
            }
            vehiclesList.add(newVehicle);
            System.out.println("Success added");
        }
    }
    

    public void deleteVehicle(String plateNum){
        for(int i=0;i< vehiclesList.size();i++){
            if(vehiclesList.get(i).getPliatNumber().equalsIgnoreCase(plateNum)){
                vehiclesList.remove(i);
                System.out.println("["+plateNum+"] has been deleted");
                return;
            }
            
        }

    }

    public Vehicle searchVehicle(String plateNum){
        for(Vehicle v : vehiclesList){
            if(v.getPliatNumber().equalsIgnoreCase(plateNum)){
                return v;
            }
           
        }
        return null;
         
        
        
    }


    public void display(){
        if(vehiclesList.isEmpty()){
            System.out.println("the system is empty");
            return;
        }
        System.out.println("=====================");
        for(Vehicle v : vehiclesList){
            System.out.println(v);
        }
        System.out.println("======================");
    }




    public void displayAvailable() {
        if (vehiclesList.isEmpty()) {
            System.out.println("the system is empty");
            return;
        }

        System.out.println("===================================");
        boolean Ava = false; 
        
        for (Vehicle v : vehiclesList) {
            if (v.isAvailable()) { 
                System.out.println(v);
                Ava = true;
            }
        }

        if (!Ava) {
            System.out.println("Sorry, all vehicles are currently rented out.");
        }
        System.out.println("===========================================");
    }
}

    



