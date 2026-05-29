import java.util.ArrayList;
public class VehicleManager {
    private ArrayList<Vehicle> vehiclesList;

    public VehicleManager() {
        this.vehiclesList=new ArrayList<>();
    }

    public void addVehicle(Vehicle newVehicle){
        for(Vehicle v:vehiclesList){
            if(v.getPlateNumber().equalsIgnoreCase(newVehicle.getPlateNumber())){
                System.out.println("[Error]"+newVehicle.getPlateNumber()+"already exists!");
                return;
            }
        }
        vehiclesList.add(newVehicle);
            System.out.println("Success added");
    }
    

    public void deleteVehicle(String plateNum){
        for(int i=0;i< vehiclesList.size();i++){
            if(vehiclesList.get(i).getPlateNumber().equalsIgnoreCase(plateNum)){
                vehiclesList.remove(i);
                System.out.println("["+plateNum+"] has been deleted");
                return;
            }
    
        }

    }

    public Vehicle searchVehicle(String plateNum){
        for(Vehicle v : vehiclesList){
            if(v.getPlateNumber().equalsIgnoreCase(plateNum)){
                return v;
            }
           
        }
        return null;
   
    }


    public void display(){
        if(vehiclesList.isEmpty()){
            System.out.println("there are no vehicles ");
            return;
        }

        for(Vehicle v : vehiclesList){
            System.out.println(v);
        }
  
    }




    public void displayAvailable() {
        if (vehiclesList.isEmpty()) {
            System.out.println("there are no vehicles");
            return;
        }

        boolean Ava = false; 
        
        for (Vehicle v : vehiclesList) {
            if (v.isAvailable()) { 
                System.out.println(v);
                Ava=true;
            }
        }

        if (!Ava) {
            System.out.println("Sorry, all vehicles are currently rented out.");
        }
    
    }
}

    



