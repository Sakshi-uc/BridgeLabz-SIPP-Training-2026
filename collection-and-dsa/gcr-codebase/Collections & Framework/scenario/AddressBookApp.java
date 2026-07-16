import java.util.*;

/**
 * 1. Address Book App
 * Stores contacts (name, phone, email).
 * - ArrayList for ordered storage
 * - HashMap for fast name lookup
 * - HashSet to prevent duplicate phone numbers
 */
public class AddressBookApp {

    static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
        }
    }

    private ArrayList<Contact> contactList = new ArrayList<>();          // ordered storage
    private HashMap<String, Contact> nameIndex = new HashMap<>();        // fast lookup by name
    private HashSet<String> phoneNumbers = new HashSet<>();              // prevent duplicate phones

    public boolean addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("Error: A contact with phone number " + phone + " already exists.");
            return false;
        }
        Contact c = new Contact(name, phone, email);
        contactList.add(c);
        nameIndex.put(name, c);
        phoneNumbers.add(phone);
        System.out.println("Contact added: " + c);
        return true;
    }

    public Contact searchByName(String name) {
        return nameIndex.get(name);
    }

    public boolean deleteContact(String name) {
        Contact c = nameIndex.get(name);
        if (c == null) {
            System.out.println("Contact not found: " + name);
            return false;
        }
        contactList.remove(c);
        nameIndex.remove(name);
        phoneNumbers.remove(c.phone);
        System.out.println("Contact deleted: " + name);
        return true;
    }

    public void displaySortedByName() {
        ArrayList<Contact> sorted = new ArrayList<>(contactList);
        sorted.sort(Comparator.comparing(c -> c.name));
        System.out.println("\n--- Address Book (sorted by name) ---");
        if (sorted.isEmpty()) {
            System.out.println("No contacts found.");
        }
        for (Contact c : sorted) {
            System.out.println(c);
        }
        System.out.println("Total contacts: " + sorted.size());
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Address Book Menu =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact by Name");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts (sorted by name)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    app.addContact(name, phone, email);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    Contact found = app.searchByName(sc.nextLine());
                    System.out.println(found != null ? "Found: " + found : "Contact not found.");
                    break;
                case 3:
                    System.out.print("Enter name to delete: ");
                    app.deleteContact(sc.nextLine());
                    break;
                case 4:
                    app.displaySortedByName();
                    break;
                case 5:
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
