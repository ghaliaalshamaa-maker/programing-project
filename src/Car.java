public class Car extends Vehicle {

    private String fuelType;
    private boolean hasAirConditioner;
    private int seatsCount;

    

    public Car(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable, String fuelType, boolean hasAirConditioner, int seatsCount) {
           
        super(pliatNumber, brand, model, dailyRate, isAvailable);
        this.fuelType = fuelType;
        this.hasAirConditioner = hasAirConditioner;
        this.seatsCount = seatsCount;
    }

    public String getFuelType() {
        return fuelType;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    @Override
    public String toString() {
        return super.toString()+"Car [fuelType=" + fuelType + ", hasAirConditioner=" + (hasAirConditioner? "Yes" : "No") + ", seatsCount=" + seatsCount+"]";
                
    }





   
    

    

}
