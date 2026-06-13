public class Contract {
    private int contractId ;
    private int vehicleId ;
    private int customerId ;
    private  double totalPrice ;
    private boolean isFinished ;

    public Contract(int contractId, int vehicleId, int customerId, double totalPrice, boolean isFinished) {
        this.contractId = contractId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.isFinished = isFinished;

    }

    public int getContractId() {
        return contractId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isIsFinished() {
        return isFinished;
    }}