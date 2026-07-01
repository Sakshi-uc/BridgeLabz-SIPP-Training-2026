import java.util.*;

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

        public String toString() {
            return "ID: " + astronautId + " | Name: " + name + " | Specialization: " + specialization;
        }
    }

    HashMap<String, List<Astronaut>> missionCrew = new HashMap<>();
    HashMap<String, HashSet<String>> missionAstronautIds = new HashMap<>();

    void addMission(String missionName) {
        if (missionCrew.containsKey(missionName)) {
            System.out.println("Mission '" + missionName + "' already exists.");
            return;
        }
        missionCrew.put(missionName, new ArrayList<>());
        missionAstronautIds.put(missionName, new HashSet<>());
        System.out.println("Mission added: " + missionName);
    }

    void assignAstronaut(String missionName, String astronautId, String name, String specialization) {
        if (!missionCrew.containsKey(missionName)) {
            System.out.println("Mission not found: " + missionName + ". Add the mission first.");
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

    void displayMissions() {
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
            System.out.println("\n1. Add New Mission");
            System.out.println("2. Assign Astronaut to Mission");
            System.out.println("3. Display All Missions and Crew");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter mission name: ");
                system.addMission(sc.nextLine());
            } else if (choice == 2) {
                System.out.print("Enter mission name: ");
                String mission = sc.nextLine();
                System.out.print("Enter astronaut ID: ");
                String id = sc.nextLine();
                System.out.print("Enter astronaut name: ");
                String name = sc.nextLine();
                System.out.print("Enter specialization: ");
                String spec = sc.nextLine();
                system.assignAstronaut(mission, id, name, spec);
            } else if (choice == 3) {
                system.displayMissions();
            } else if (choice == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
