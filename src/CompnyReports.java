import java.util.ArrayList;                                                                                              public class CompnyReports {


    public static double calculateTotalRevenue(ArrayList<Contract> contractsList) {
        double totalRevenue = 0;
        for (Contract contract : contractsList) {
            totalRevenue = totalRevenue + contract.getTotalPrice();
        }
        return totalRevenue;
    }


    public static void printMostRentedVehicle(ArrayList<Contract> contractsList) {


        if (contractsList.isEmpty()) {
            System.out.println("There are no contracts currently in the system to calculate the most frequently rented vehicle");
            return;
        }

        int mostRentedVehicleId = -1;
        int maxRentalCount = 0;


        for (int i = 0; i < contractsList.size(); i++) {
            int currentVehicleId = contractsList.get(i).getVehicleId();
            int currentCount = 0;


            for (Contract contract : contractsList) {
                if (contract.getVehicleId() == currentVehicleId) {
                    currentCount++;
                }
            }


            if (currentCount > maxRentalCount) {
                maxRentalCount = currentCount;
                mostRentedVehicleId = currentVehicleId;
            }
        }


        System.out.println(" REPORT OF THE MOST RENTED VEHICLES ");
        System.out.println(" THE MOST REQUESTED AND RENTED VEHICLE NUMBER IS :" + mostRentedVehicleId);
        System.out.println(" NUMBER OF TIMES IT HAS BEEN RENTED : " + maxRentalCount + " TIMES ");
    }
    public static void printVIPCustomers(ArrayList<Integer> customersList, ArrayList<Contract> contractsList) {
        System.out.println("FEATURED CUSTOMER REPORT");
        boolean foundVIP = false;


        for (Integer customerId : customersList) {
            int finishedContractsCount = 0;


            for (Contract contract : contractsList) {
                if (contract.getCustomerId() == customerId && contract.isIsFinished() == true) {
                    finishedContractsCount++;
                }
            }

            if (finishedContractsCount >= 5) {
                System.out.println(" CUSTOMER NUMBER : (" + customerId + ") HE IS A SPECIAL CLIENT OF HIS  " + finishedContractsCount + " EXPIRING ");
                foundVIP = true;
            }
        }


    }
}
