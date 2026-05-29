public class Motorcycle extends Vehicle{
    private int enginenolpCapacity;
    private boolean hasSidecar;

    

    public Motorcycle(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable,int enginenolpCapacity, boolean hasSidecar) {
            
        super(pliatNumber, brand, model, dailyRate, isAvailable);
        this.enginenolpCapacity = enginenolpCapacity;
        this.hasSidecar = hasSidecar;
    }



    @Override
    public String toString() {
        return super.toString()+"Motorcycle [enginenolpCapacity=" + enginenolpCapacity + ", hasSidecar=" + hasSidecar + "]";
    }



    

    

    

}
