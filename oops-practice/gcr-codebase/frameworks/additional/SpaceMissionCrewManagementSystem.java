import java.util.*;

/**
 * Additional 2. Space Mission Crew Management System
 * - Astronaut class (astronautId, name, specialization)
 * - HashMap<String, List<Astronaut>> for mission-wise crew allocation
 * - HashSet<String> per mission to prevent duplicate astronaut assignment
 */
public class SpaceMissionCrewManagementSystem {

    static class Astronaut {
        String astronautId;
        String name;
        String specialization;

        Astronaut(String astronautId, String name, String specialization) {
            this.astronautId = astronautId;
            this.name = name;
            this.specialization = specialization;
        }

        @Override
        public String toString() {
            return "ID: " + astronautId + " | Name: " + name + " | Specialization: " + specialization;
        }
    }

    private HashMap<String, List<Astronaut>> missionCrew = new HashMap<>();
    private HashMap<String, HashSet<String>> missionAstronautIds = new HashMap<>(); // mission -> set of astronaut IDs

    public void addMission(String missionName) {
        if (missionCrew.containsKey(missionName)) {
            System.out.println("Mission '" + missionName + "' already exists.");
            return;
        }
        missionCrew.put(missionName, new ArrayList<>());
        missionAstronautIds.put(missionName, new HashSet<>());
        System.out.println("Mission added: " + missionName);
    }

    public void assignAstronaut(String missionName, String astronautId, String name, String specialization) {
        if (!missionCrew.containsKey(missionName)) {
            System.out.println("Mission not found: " + missionName + ". Please add the mission first.");
            return;
        }
        HashSet<String> idsForMission = missionAstronautIds.get(missionName);
        if (idsForMission.contains(astronautId)) {
            System.out.println("Astronaut " + astronautId + " is already assigned to mission " + missionName + ".");
            return;
        }
        Astronaut astronaut = new Astronaut(astronautId, name, specialization);
        missionCrew.get(missionName).add(astronaut);
        idsForMission.add(astronautId);
        System.out.println("Assigned " + name + " (" + astronautId + ") to mission " + missionName + ".");
    }

    public void displayMissions() {
        System.out.println("\n--- Mission Details ---");
        if (missionCrew.isEmpty()) {
            System.out.println("No missions have been created yet.");
            return;
        }
        for (Map.Entry<String, List<Astronaut>> entry : missionCrew.entrySet()) {
            System.out.println("\nMission: " + entry.getKey());
            List<Astronaut> crew = entry.getValue();
            if (crew.isEmpty()) {
                System.out.println("   No astronauts assigned yet.");
            } else {
                for (Astronaut a : crew) {
                    System.out.println("   - " + a);
                }
            }
            System.out.println("   Total astronauts assigned: " + crew.size());
        }
    }

    public static void main(String[] args) {
        SpaceMissionCrewManagementSystem system = new SpaceMissionCrewManagementSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Space Mission Crew Management System =====");
            System.out.println("1. Add New Mission");
            System.out.println("2. Assign Astronaut to Mission");
            System.out.println("3. Display All Missions and Crew");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter mission name: ");
                    system.addMission(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter mission name: ");
                    String mission = sc.nextLine();
                    System.out.print("Enter astronaut ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter astronaut name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter specialization: ");
                    String spec = sc.nextLine();
                    system.assignAstronaut(mission, id, name, spec);
                    break;
                case 3:
                    system.displayMissions();
                    break;
                case 4:
                    System.out.println("Exiting Space Mission Crew Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
