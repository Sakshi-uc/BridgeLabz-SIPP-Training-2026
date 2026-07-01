import java.util.*;

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

        public String toString() {
            return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
        }
    }

    ArrayList<Contact> contactList = new ArrayList<>();
    HashMap<String, Contact> nameIndex = new HashMap<>();
    HashSet<String> phoneNumbers = new HashSet<>();

    boolean addContact(String name, String phone, String email) {
        if (phoneNumbers.contains(phone)) {
            System.out.println("A contact with phone number " + phone + " already exists.");
            return false;
        }
        Contact c = new Contact(name, phone, email);
        contactList.add(c);
        nameIndex.put(name, c);
        phoneNumbers.add(phone);
        System.out.println("Contact added: " + c);
        return true;
    }

    Contact searchByName(String name) {
        return nameIndex.get(name);
    }

    boolean deleteContact(String name) {
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

    void displaySortedByName() {
        ArrayList<Contact> sorted = new ArrayList<>(contactList);
        Collections.sort(sorted, (a, b) -> a.name.compareTo(b.name));
        System.out.println("\n--- Address Book ---");
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
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search Contact by Name");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                app.addContact(name, phone, email);
            } else if (choice == 2) {
                System.out.print("Enter name to search: ");
                Contact found = app.searchByName(sc.nextLine());
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter name to delete: ");
                app.deleteContact(sc.nextLine());
            } else if (choice == 4) {
                app.displaySortedByName();
            } else if (choice == 5) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
