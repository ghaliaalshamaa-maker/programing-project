public class Corporation extends Customer {
    private String taxNumber;
    private double discount;

    public Corporation(String customerId, String name, String address, String phone, String taxNumber, double discount) {
        super(customerId, name, address, phone);
        this.taxNumber = taxNumber;
        this.discount = discount;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return super.toString()+"Corporation [taxNumber=" + taxNumber + ", discount=" + (discount*100) +"%"+"]";
    }

    

    
    


}
