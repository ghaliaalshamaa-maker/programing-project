public class Truck extends Vehicle{
    private double capacity;
    private boolean refrigerated;

    

    public Truck(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable, double capacity, boolean refrigerated) {    
        super(pliatNumber, brand, model, dailyRate, isAvailable);
        this.capacity = capacity;
        this.refrigerated = refrigerated;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isRefrigerated() {
        return refrigerated;
    }

    public void setRefrigerated(boolean refrigerated) {
        this.refrigerated = refrigerated;
    }

    
    @Override
    public String toString() {
        return super.toString()+"Truck [capacity=" + capacity + ", refrigerated=" + (refrigerated? "Yes": "No")+ "]";
    }

    

    

    

}
