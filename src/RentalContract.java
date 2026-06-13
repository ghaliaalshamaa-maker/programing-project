import java.time.LocalDate;
public class RentalContract {

    private int id;
    private Vehicle vehicle;
    private Customer customer;
    private String startDate;
    private int rentalDays;
    private int delayDays;
    private String actualReturnDate;
    private double basicCost;
    private boolean isActive;

    public RentalContract(int id, Vehicle vehicle, Customer customer, String startDate, int rentalDays) {
        this.id = id;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.rentalDays = rentalDays;
        this.isActive = true;
        this.delayDays = 0;
        this.actualReturnDate = "";
        this.vehicle.setAvailable(false);
        this.basicCost = vehicle.claculateCost(this.rentalDays);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public int getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(int delayDays) {
        this.delayDays = delayDays;
    }

    public String getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(String actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public double getBasicCost() {
        return basicCost;
    }

    public void setBasicCost(double basicCost) {
        this.basicCost = basicCost;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double calculateDiscount() {
        return basicCost * customer.getDiscountRate();
    }

    public double calculatePenalty() {
        return basicCost * 0.10 * delayDays;
    }

    public double calculateFinalCost() {
        return basicCost - calculateDiscount() + calculatePenalty();
    }


    public String getExpectedReturnDate() {
        LocalDate start = LocalDate.parse(startDate);
        return start.plusDays(rentalDays).toString();
    }
    public void completeReturn(String returnDate, int delay) {
        this.actualReturnDate = returnDate;
        this.delayDays = delay;
        this.isActive = false;
        this.vehicle.setAvailable(true);
    }

    public void printContractDetails() {
        System.out.println("          Rental Contract Details          ");
        System.out.println("Contract ID: " + this.id);
        System.out.println("Start Date: " + this.startDate);
        System.out.println("Rental Days: " + this.rentalDays);
        System.out.println("Status: " + (this.isActive ? "Active" : "Ended"));
        System.out.println("Basic Cost: " + this.basicCost);
        System.out.println("Vehicle: " + this.vehicle);
        System.out.println("Customer: " + this.customer);
        if (!isActive) {
            System.out.println("Actual Return Date: " + this.actualReturnDate);
            System.out.println("Delay Days: " + this.delayDays);
        }
    }

    public void printInvoice() {
        System.out.println("          Final Invoice          ");
        System.out.println("Contract ID: " + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getPlateNumber());
        System.out.println("Basic Cost: " + basicCost);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Delay Penalty (" + delayDays + " days): " + calculatePenalty());
        System.out.println("Total: " + calculateFinalCost());
    }
}
