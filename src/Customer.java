public abstract class Customer {
    private String customerId;
    private String name;
    private String address;
    private String Phone;



    public Customer(String customerId, String name, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.Phone = phone;
    }

    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


   
    public String toString() {
        return "customerId=" + customerId + ", name=" + name + ", address=" + address + ", Phone=" + Phone ;
               
    }

 
}
