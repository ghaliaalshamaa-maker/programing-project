public abstract class Vehicle {
    protected String pliatNumber;
    protected String brand;
    protected String model;
    protected double dailyRate;
    protected boolean isAvailable;

    public Vehicle(String pliatNumber, String brand, String model, double dailyRate, boolean isAvailable) {
        this.pliatNumber = pliatNumber;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }

    public String getPliatNumber() {
        return pliatNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    String n=" ";
    if(isAvailable==true)
        n="Yes";
    else
        n="No";

    @Override
    public String toString() {
        return "pliatNumber=" + pliatNumber + ", brand=" + brand + ", model=" + model + ", dailyRate=" + dailyRate + ", isAvailable=" + (isAvailable? "Yes":"No") ;
               
    }

}
