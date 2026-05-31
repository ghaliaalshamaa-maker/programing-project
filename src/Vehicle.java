public abstract class Vehicle {
    private String plateNumber;
    private String brand;
    private String model;
    private double dailyRate;
    private boolean isAvailable;

    public Vehicle(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable) {
        this.plateNumber = pliatNumber;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }
   
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public String toString() {
        return "pliatNumber=" + plateNumber + ", brand=" + brand + ", model=" + model + ", dailyRate=" + dailyRate + ", isAvailable=" + (isAvailable? "Yes":"No") ;
               
    }

}
