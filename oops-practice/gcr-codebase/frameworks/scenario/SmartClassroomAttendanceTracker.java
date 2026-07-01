import java.util.*;

public class SmartClassroomAttendanceTracker {

    HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);
        if (students.contains(student)) {
            System.out.println(student + " is already marked present for " + subject + ".");
        } else {
            students.add(student);
            System.out.println("Marked: " + student + " -> " + subject);
        }
    }

    void displayAttendance() {
        System.out.println("\n--- Subject-wise Attendance ---");
        if (attendance.isEmpty()) {
            System.out.println("No attendance records yet.");
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : attendance.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            for (String student : entry.getValue()) {
                System.out.println("   - " + student);
            }
            System.out.println("   Total present: " + entry.getValue().size());
        }
    }

    public static void main(String[] args) {
        SmartClassroomAttendanceTracker tracker = new SmartClassroomAttendanceTracker();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Mark Attendance");
            System.out.println("2. Display Attendance for All Subjects");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            if (choice == 1) {
                System.out.print("Enter subject name: ");
                String subject = sc.nextLine();
                System.out.print("Enter student name: ");
                String student = sc.nextLine();
                tracker.markAttendance(subject, student);
            } else if (choice == 2) {
                tracker.displayAttendance();
            } else if (choice == 3) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
