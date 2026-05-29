public abstract class Customer {
    protected String customerId;
    protected String name;
    protected String address;
    protected String Phone;

    

    public Customer(String customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.Phone = phone;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return Phone;
    }

    @Override
    public String toString() {
        return "customerId=" + customerId + ", name=" + name + ", address=" + address + ", Phone=" + Phone ;
               
    }

    

    

    


}
