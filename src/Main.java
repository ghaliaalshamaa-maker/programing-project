
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String args []){

        Scanner input = new Scanner(System.in);
        ArrayList<Contract> contracts = new ArrayList<>();
        ArrayList<Integer> customers = new ArrayList<>();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- CUSTOMER MANAGEMENT SYSTEM ---");
            System.out.println("1. ADD CUSTOMER");
            System.out.println("2. SEARCH CUSTOMER");
            System.out.println("3. DISPLAY ALL CUSTOMERS");
            System.out.println("4. UPDATE CUSTOMER");
            System.out.println("5. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");

            System.out.println("ENTER YOUR CHOICE : ");
            String choiceStr = input.nextLine() ;
            choice = Integer . parseInt (choiceStr);

            switch (choice) {
                case 1: CustomerManagement.addCustomer(); break;
                case 2: CustomerManagement.searchCustomer(); break;
                case 3: CustomerManagement.displayAllCustomers(); break;
                case 4: CustomerManagement.updateCustomer(); break;
                case 5: System.out.println("GOODBYE!"); break;
                default: System.out.println("INVALID CHOICE!");
            }


        customers.add(1);
        customers.add(2);


        contracts.add(new Contract(101, 55, 1, 200.0, true));
        contracts.add(new Contract(102, 55, 1, 150.0, true));
        contracts.add(new Contract(103, 77, 1, 300.0, true));
        contracts.add(new Contract(104, 55, 1, 250.0, true));
        contracts.add(new Contract(105, 99, 1, 400.0, true));

        contracts.add(new Contract(106, 77, 2, 500.0, true));


        System.out.println(" THE COMPANYS TOTAL REVENUES: " + CompnyReports.calculateTotalRevenue(contracts) + " SYP ");
        System.out.println("-----------------------------------");

        CompnyReports.printMostRentedVehicle(contracts);
        System.out.println("-----------------------------------");

        CompnyReports.printVIPCustomers(customers, contracts);
    }

}}
