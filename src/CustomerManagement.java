import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManagement {
    static ArrayList<Customer>
            customerList = new ArrayList <> () ;
    static Scanner input = new Scanner (System.in );

    public static void addCustomer() {
        System.out.println("ADD NEW CUSTOMER ");
        System.out.println("ENTER THE CUSTOMERID : ");
        String id = input.next();
        input.nextLine();
        System.out.println("ENTER THE CUSTOMER NAME ");
        String name =input.nextLine();
        System.out.println("ENTER YOUR EMAIL ");
        String email = input.nextLine();
        System.out.println("ENTER YOUR PHONE NUMBER ");
        String phone = input.nextLine();
        Customer newCustomer = new Customer ( id , name , email ,phone);
        customerList.add(newCustomer);
        System.out.println("CUSTOMER ADD SUCCESSFULLY !");


    }
    public static void searchCustomer() {

        System.out.println("SEARCH FOR A CUSTOMER ");
        System.out.println("ENTER THE CUSTOMER ID TO SEARCH : ");
        String searchId = input.next();
        input.nextLine();
        boolean isFound = false ;
        for(Customer c : customerList ){
            if(searchId == c.getCustomerId()){

                c.toString();
                isFound = true ;
                break ;

            }

        }
        if (!isFound){
            System.out.println("CUSTOMER NOT FOUND !");

        }
    }
    public static void displayAllCustomers (){
        System.out.println(" \n ALL CUSTOMERS LIST ");
        if (customerList.isEmpty()){
            System.out.println("NO CUSTOMERS FOUND");
        }
        else {
            for (Customer c : customerList )
                c.toString() ;

        }
    }
    public static void updateCustomer () {

        System.out.println("\n UPDATE CUSTOMER DATA ");
        System.out.println(" ENTER THE CUSTOMER ID TO UPDATE : ");
        String updateId = input.next();
        input.nextLine();

        boolean isFound = false ;
        for (Customer c : customerList ){
            if (c.getCustomerId() == updateId){

                System.out.println("ENTER NEW NAME: ");
                String newName = input.nextLine();
                System.out.println("ENTER NEW EMAIL: ");
                String newEmail = input.nextLine();

                c.setName(newName);
                c.setAddress(newEmail);

                System.out.println("CUSTOMER UPDATED SUCCESSFULLY!");

                isFound = true;

                break;
            }
        }
        if (!isFound) {
            System.out.println("SORRY, CUSTOMER NOT FOUND.");
        }

    }


}