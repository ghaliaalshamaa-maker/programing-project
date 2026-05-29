public class Truck extends Vehicle{
    private double capacity;
    private boolean refrigerated;

    

    public Truck(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable, double capacity,
            boolean refrigerated) {
        super(pliatNumber, brand, model, dailyRate, isAvailable);
        this.capacity = capacity;
        this.refrigerated = refrigerated;
    }

    public boolean isRefrigerated() {
        return refrigerated;
    }

    @Override
    public String toString() {
        return super.toString()+"Truck [capacity=" + capacity + ", refrigerated=" + (refrigerated? "Yes": "No")+ "]";
    }

    

    

    

}
