import java.util.*;

public class EventEntryVerificationSystem {

    HashSet<String> registeredEmails = new HashSet<>();

    void register(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Rejected: " + email + " is already registered.");
        } else {
            registeredEmails.add(email);
            System.out.println("Registration successful for: " + email);
        }
    }

    void displayParticipants() {
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
            System.out.println("\n1. Register Participant");
            System.out.println("2. Display All Registered Participants");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter participant email ID: ");
                system.register(sc.nextLine());
            } else if (choice == 2) {
                system.displayParticipants();
            } else if (choice == 3) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
