public class Motorcycle extends Vehicle{
    private int engineCapacity;
    private boolean hasSidecar;

    

    public Motorcycle(String plateNumber, String brand, String model, double dailyRate, boolean isAvailable,int enginenolpCapacity, boolean hasSidecar) {
            
        super(plateNumber, brand, model, dailyRate, isAvailable);
        this.engineCapacity = enginenolpCapacity;
        this.hasSidecar = hasSidecar;
    }

    
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int enginenolpCapacity) {
        this.engineCapacity = enginenolpCapacity;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }


    @Override
    public String toString() {
        return super.toString()+"Motorcycle [enginenolpCapacity=" + engineCapacity + ", hasSidecar=" + hasSidecar + "]";
    }



    

    

    

}
