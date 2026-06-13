import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManagement {
    private static final ArrayList<RentalContract> contracts = new ArrayList<>();
    private static int nextContractId = 1;
    private static final Scanner input = new Scanner(System.in);

    public static void createRental(VehicleManager vehicleManager) {
        System.out.println("\n--- CREATE RENTAL CONTRACT ---");
        System.out.print("Enter vehicle plate number: ");
        String plate = input.nextLine();
        Vehicle vehicle = vehicleManager.searchVehicle(plate);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        if (!vehicle.isAvailable()) {
            System.out.println("Vehicle is not available.");
            return;
        }

        System.out.print("Enter customer ID: ");
        String customerId = input.nextLine();
        Customer customer = CustomerManagement.findById(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter start date (yyyy-MM-dd): ");
        String startDate = input.nextLine();
        System.out.print("Enter rental days: ");
        int rentalDays = input.nextInt();
        input.nextLine(); // Consume newline

        RentalContract contract = new RentalContract(nextContractId++, vehicle, customer, startDate, rentalDays);
        contracts.add(contract);
        System.out.println("Rental contract created successfully.");
        contract.printContractDetails();
    }

    public static void returnVehicle() {
        System.out.println("\n--- RETURN VEHICLE ---");
        System.out.print("Enter contract ID: ");
        int contractId = input.nextInt();
        input.nextLine(); // Consume newline

        RentalContract contract = findContractById(contractId);
        if (contract == null) {
            System.out.println("Contract not found.");
            return;
        }
        if (!contract.isActive()) {
            System.out.println("Contract is already ended.");
            return;
        }

        System.out.print("Enter actual return date (yyyy-MM-dd): ");
        String returnDateStr = input.nextLine();

        LocalDate expectedReturn = LocalDate.parse(contract.getExpectedReturnDate());
        LocalDate actualReturn = LocalDate.parse(returnDateStr);

        int delay = 0;
        if (actualReturn.isAfter(expectedReturn)) {

            delay = (int) (actualReturn.toEpochDay() - expectedReturn.toEpochDay());
        }

        contract.completeReturn(returnDateStr, delay);
        contract.printInvoice();
    }

    public static void displayActiveContracts() {
        System.out.println("\n--- ACTIVE RENTAL CONTRACTS ---");
        boolean found = false;
        for (RentalContract c : contracts) {
            if (c.isActive()) {
                c.printContractDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active contracts.");
        }
    }

    public static void displayEndedContracts() {
        System.out.println("\n--- ENDED RENTAL CONTRACTS ---");
        boolean found = false;
        for (RentalContract c : contracts) {
            if (!c.isActive()) {
                c.printContractDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No ended contracts.");
        }
    }

    public static void displayContractsByCustomerName() {
        System.out.print("\nEnter customer name: ");
        String name = input.nextLine();
        boolean found = false;
        for (RentalContract c : contracts) {
            if (c.getCustomer().getName().equalsIgnoreCase(name)) {
                c.printContractDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contracts found for this customer.");
        }
    }

    public static void displayCorporationContracts() {
        System.out.println("\n--- CORPORATION RENTAL CONTRACTS ---");
        boolean found = false;
        for (RentalContract c : contracts) {
            if (c.getCustomer() instanceof Corporation) {
                c.printContractDetails();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No corporation contracts found.");
        }
    }

    public static void displayCurrentlyRentedVehicles() {
        System.out.println("\n--- CURRENTLY RENTED VEHICLES ---");
        boolean found = false;
        for (RentalContract c : contracts) {
            if (c.isActive()) {
                System.out.println(c.getVehicle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles are currently rented.");
        }
    }

    public static void displayVehiclesWithDelayPenalties() {
        System.out.println("\n--- VEHICLES WITH CURRENT DELAY PENALTIES ---");
        boolean found = false;
        LocalDate today = LocalDate.now();

        for (RentalContract c : contracts) {
            if (c.isActive()) {
                LocalDate expectedReturn = LocalDate.parse(c.getExpectedReturnDate());

                if (today.isAfter(expectedReturn)) {
                    // حساب أيام التأخير الحالية بعملية طرح بسيطة
                    int currentDelay = (int) (today.toEpochDay() - expectedReturn.toEpochDay());
                    System.out.println(c.getVehicle());
                    System.out.println("Contract #" + c.getId() + " is OVERDUE by " + currentDelay + " days.");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("No currently delayed vehicles found.");
        }
    }

    public static void displayVehiclesRentedInPeriod(boolean motorcyclesOnly) {
        System.out.print("Enter period start (yyyy-MM-dd): ");
        String periodStartStr = input.nextLine();
        System.out.print("Enter period end (yyyy-MM-dd): ");
        String periodEndStr = input.nextLine();

        LocalDate periodStart = LocalDate.parse(periodStartStr);
        LocalDate periodEnd = LocalDate.parse(periodEndStr);

        String title = motorcyclesOnly ? "\n--- MOTORCYCLES RENTED IN PERIOD ---" : "\n--- VEHICLES RENTED IN PERIOD ---";
        System.out.println(title);
        boolean found = false;

        for (RentalContract c : contracts) {
            if (motorcyclesOnly && !(c.getVehicle() instanceof Motorcycle)) {
                continue;
            }

            LocalDate rentalStart = LocalDate.parse(c.getStartDate());
            String endStr = c.isActive() || c.getActualReturnDate().isEmpty() ? c.getExpectedReturnDate() : c.getActualReturnDate();
            LocalDate rentalEnd = LocalDate.parse(endStr);

            if (isRentalInPeriod(rentalStart, rentalEnd, periodStart, periodEnd)) {
                System.out.println(c.getVehicle());
                System.out.println("Contract #" + c.getId() + ", Start: " + c.getStartDate() + ", Days: " + c.getRentalDays());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching rentals in this period.");
        }
    }

    public static void displayCustomersWhoRentedVehicle(VehicleManager vehicleManager) {
        System.out.print("\nEnter vehicle plate number: ");
        String plate = input.nextLine();
        Vehicle vehicle = vehicleManager.searchVehicle(plate);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.println("--- CUSTOMERS WHO RENTED THIS VEHICLE ---");
        boolean found = false;
        for (RentalContract c : contracts) {
            if (c.getVehicle().getPlateNumber().equalsIgnoreCase(plate)) {
                System.out.println(c.getCustomer());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No customers rented this vehicle.");
        }
    }

    private static RentalContract findContractById(int id) {
        for (RentalContract c : contracts) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private static boolean isRentalInPeriod(LocalDate rStart, LocalDate rEnd, LocalDate pStart, LocalDate pEnd) {
        return !(rStart.isAfter(pEnd) || rEnd.isBefore(pStart));
    }
}
