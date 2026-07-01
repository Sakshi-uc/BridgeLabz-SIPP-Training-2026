import java.util.*;

public class SmartCityTrafficMonitoringSystem {

    HashMap<String, Integer> roadTraffic = new HashMap<>();

    void addOrUpdateRoad(String roadName, int vehicleCount) {
        int updatedCount = roadTraffic.getOrDefault(roadName, 0) + vehicleCount;
        roadTraffic.put(roadName, updatedCount);
        System.out.println("Updated " + roadName + " -> total vehicle count: " + updatedCount);
    }

    void displaySortedByRoadName() {
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(roadTraffic);
        System.out.println("\n--- Roads Sorted by Name ---");
        if (sortedRoads.isEmpty()) {
            System.out.println("No road data available.");
            return;
        }
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vehicles");
        }
    }

    void displayBusiestRoad() {
        if (roadTraffic.isEmpty()) {
            System.out.println("No road data available.");
            return;
        }
        String busiestRoad = null;
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : roadTraffic.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }
        System.out.println("Busiest road: " + busiestRoad + " with " + maxCount + " vehicles.");
    }

    void generateTrafficReport() {
        System.out.println("\n--- Traffic Analysis Report ---");
        if (roadTraffic.isEmpty()) {
            System.out.println("No road data available.");
            return;
        }
        TreeMap<String, Integer> sortedRoads = new TreeMap<>(roadTraffic);
        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {
            String status;
            int count = entry.getValue();
            if (count >= 1000) {
                status = "Heavy Traffic";
            } else if (count >= 500) {
                status = "Moderate Traffic";
            } else {
                status = "Light Traffic";
            }
            System.out.println(entry.getKey() + " -> " + count + " vehicles -> " + status);
        }
        displayBusiestRoad();
        System.out.println("Total roads monitored: " + roadTraffic.size());
    }

    public static void main(String[] args) {
        SmartCityTrafficMonitoringSystem system = new SmartCityTrafficMonitoringSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add/Update Vehicle Count for a Road");
            System.out.println("2. Display Roads Sorted by Name");
            System.out.println("3. Identify Busiest Road");
            System.out.println("4. Generate Traffic Analysis Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter road name: ");
                String road = sc.nextLine();
                System.out.print("Enter vehicle count to add: ");
                int count = Integer.parseInt(sc.nextLine().trim());
                system.addOrUpdateRoad(road, count);
            } else if (choice == 2) {
                system.displaySortedByRoadName();
            } else if (choice == 3) {
                system.displayBusiestRoad();
            } else if (choice == 4) {
                system.generateTrafficReport();
            } else if (choice == 5) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
