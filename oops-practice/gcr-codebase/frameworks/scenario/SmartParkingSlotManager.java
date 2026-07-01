import java.util.*;

/**
 * 2. Smart Parking Slot Manager
 * Uses ArrayList<String> to store vehicle registration numbers currently parked.
 */
public class SmartParkingSlotManager {

    private ArrayList<String> parkedVehicles = new ArrayList<>();

    public void enterParking(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle " + regNumber + " is already parked!");
            return;
        }
        parkedVehicles.add(regNumber);
        System.out.println("Vehicle " + regNumber + " has entered the parking area.");
    }

    public void exitParking(String regNumber) {
        if (parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle " + regNumber + " has exited the parking area.");
        } else {
            System.out.println("Vehicle " + regNumber + " not found in parking area.");
        }
    }

    public void searchVehicle(String regNumber) {
        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle " + regNumber + " is currently parked.");
        } else {
            System.out.println("Vehicle " + regNumber + " is NOT currently parked.");
        }
    }

    public void displayParkedVehicles() {
        System.out.println("\n--- Currently Parked Vehicles ---");
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
        } else {
            for (String v : parkedVehicles) {
                System.out.println(v);
            }
        }
        System.out.println("Total occupied slots: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        SmartParkingSlotManager manager = new SmartParkingSlotManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Smart Parking Slot Manager =====");
            System.out.println("1. Vehicle Enters Parking");
            System.out.println("2. Vehicle Exits Parking");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display All Parked Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle registration number: ");
                    manager.enterParking(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter vehicle registration number: ");
                    manager.exitParking(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter vehicle registration number to search: ");
                    manager.searchVehicle(sc.nextLine());
                    break;
                case 4:
                    manager.displayParkedVehicles();
                    break;
                case 5:
                    System.out.println("Exiting Parking Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
