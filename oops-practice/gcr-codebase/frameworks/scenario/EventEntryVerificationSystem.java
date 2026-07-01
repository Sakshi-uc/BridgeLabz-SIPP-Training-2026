import java.util.*;

/**
 * 3. Event Entry Verification System
 * Uses HashSet<String> to store participant email IDs and prevent duplicates.
 */
public class EventEntryVerificationSystem {

    private HashSet<String> registeredEmails = new HashSet<>();

    public void register(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Registration rejected: " + email + " is already registered.");
        } else {
            registeredEmails.add(email);
            System.out.println("Registration successful for: " + email);
        }
    }

    public void displayParticipants() {
        System.out.println("\n--- Registered Participants ---");
        if (registeredEmails.isEmpty()) {
            System.out.println("No participants registered yet.");
        } else {
            for (String email : registeredEmails) {
                System.out.println(email);
            }
        }
        System.out.println("Total attendees eligible to enter: " + registeredEmails.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem system = new EventEntryVerificationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Event Entry Verification System =====");
            System.out.println("1. Register Participant");
            System.out.println("2. Display All Registered Participants");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter participant email ID: ");
                    system.register(sc.nextLine());
                    break;
                case 2:
                    system.displayParticipants();
                    break;
                case 3:
                    System.out.println("Exiting Event Entry Verification System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
