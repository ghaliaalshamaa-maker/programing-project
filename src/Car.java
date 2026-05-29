public class Car extends Vehicle {

    private String fuelType;
    private boolean hasAirConditioner;
    private int seatsCount;

    

    public Car(String plateNumber, String brand, String model, double dailyRate, boolean isAvailable, String fuelType, boolean hasAirConditioner, int seatsCount) {
           
        super(plateNumber, brand, model, dailyRate, isAvailable);
        this.fuelType = fuelType;
        this.hasAirConditioner = hasAirConditioner;
        this.seatsCount = seatsCount;
    }

    

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }
    

    @Override
    public String toString() {
        return super.toString()+"Car [fuelType=" + fuelType + ", hasAirConditioner=" + (hasAirConditioner? "Yes" : "No") + ", seatsCount=" + seatsCount+"]";
                
    }





   
    

    

}
