

import java.util.Scanner;

public class Main {
    public static void main (String args []){

        Scanner input = new Scanner(System.in);
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
        }
    }
}
