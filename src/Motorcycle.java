public class Motorcycle extends Vehicle {

    private double engineCapacity;
    private boolean hasSidecar;

    public Motorcycle(String plateNumber, String brand, String model, double dailyRate, boolean isAvailable, double enginenolpCapacity, boolean hasSidecar) {

        super(plateNumber, brand, model, dailyRate, isAvailable);
        this.engineCapacity = enginenolpCapacity;
        this.hasSidecar = hasSidecar;
    }

    public double claculateCost(int day) {
        double cost = this.getDailyRate() * day;
        if (this.hasSidecar) {
            cost += cost * 0.02;
        }
        if (this.engineCapacity >= 1000)//100cc
        {
            cost += cost * 0.04;
        }
        return cost;

    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double enginenolpCapacity) {
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
        return super.toString() + "Motorcycle [enginenolpCapacity=" + engineCapacity + ", hasSidecar=" + (hasSidecar ? "Yes" : "No") + "]";
    }

}
