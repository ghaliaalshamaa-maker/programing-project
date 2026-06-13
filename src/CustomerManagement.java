import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    static ArrayList<Customer> customerList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void addCustomer() {
        System.out.println("ADD NEW CUSTOMER ");
        System.out.println("1 - Individual (Person)");
        System.out.println("2 - Company (Corporation)");
        System.out.print("Choose type: ");
        int type = input.nextInt();
        input.nextLine();

        System.out.println("ENTER THE CUSTOMER ID : ");
        String id = input.nextLine();
        System.out.println("ENTER THE CUSTOMER NAME ");
        String name = input.nextLine();
        System.out.println("ENTER YOUR ADDRESS ");
        String address = input.nextLine();
        System.out.println("ENTER YOUR PHONE NUMBER ");
        String phone = input.nextLine();

        Customer newCustomer;
        if (type == 2) {
            System.out.println("ENTER TAX NUMBER: ");
            String taxNumber = input.nextLine();
            System.out.println("ENTER DISCOUNT RATE (example 0.1 for 10%): ");
            double discount = input.nextDouble();
            input.nextLine();
            newCustomer = new Corporation(id, name, address, phone, taxNumber, discount);
        } else {
            System.out.println("ENTER LICENSE NUMBER: ");
            int license = input.nextInt();
            System.out.println("ENTER BIRTH DATE (year month day): ");
            int y = input.nextInt();
            int m = input.nextInt();
            int d = input.nextInt();
            input.nextLine();
            newCustomer = new Person(id, name, address, phone, license, y, m, d);
        }

        customerList.add(newCustomer);
        System.out.println("CUSTOMER ADDED SUCCESSFULLY !");
    }

    public static void searchCustomer() {
        System.out.println("SEARCH FOR A CUSTOMER ");
        System.out.println("1 - By ID");
        System.out.println("2 - By Name");
        System.out.print("Choose: ");
        int choice = input.nextInt();
        input.nextLine();

        boolean isFound = false;
        if (choice == 1) {
            System.out.println("ENTER THE CUSTOMER ID TO SEARCH : ");
            String searchId = input.nextLine();
            for (Customer c : customerList) {
                if (searchId.equals(c.getCustomerId())) {
                    System.out.println(c);
                    isFound = true;
                    break;
                }
            }
        } else {
            System.out.println("ENTER THE CUSTOMER NAME TO SEARCH : ");
            String searchName = input.nextLine();
            for (Customer c : customerList) {
                if (c.getName().equalsIgnoreCase(searchName)) {
                    System.out.println(c);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("CUSTOMER NOT FOUND !");
        }
    }

    public static void displayAllCustomers() {
        System.out.println(" \n ALL CUSTOMERS LIST ");
        if (customerList.isEmpty()) {
            System.out.println("NO CUSTOMERS FOUND");
        } else {
            for (Customer c : customerList) {
                System.out.println(c);
            }
        }
    }

    public static void updateCustomer() {
        System.out.println("\n UPDATE CUSTOMER DATA ");
        System.out.println(" ENTER THE CUSTOMER ID TO UPDATE : ");
        String updateId = input.nextLine();

        boolean isFound = false;
        for (Customer c : customerList) {
            if (c.getCustomerId().equals(updateId)) {
                System.out.println("ENTER NEW NAME: ");
                String newName = input.nextLine();
                System.out.println("ENTER NEW ADDRESS: ");
                String newAddress = input.nextLine();
                System.out.println("ENTER NEW PHONE: ");
                String newPhone = input.nextLine();

                c.setName(newName);
                c.setAddress(newAddress);
                c.setPhone(newPhone);

                System.out.println("CUSTOMER UPDATED SUCCESSFULLY!");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("SORRY, CUSTOMER NOT FOUND.");
        }
    }

    public static Customer findById(String id) {
        for (Customer c : customerList) {
            if (c.getCustomerId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
}
