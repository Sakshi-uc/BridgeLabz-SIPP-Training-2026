import java.util.*;

/**
 * 4. Smart Classroom Attendance Tracker
 * Uses HashMap<String, ArrayList<String>>
 * Key -> Subject Name, Value -> List of students present in that subject
 */
public class SmartClassroomAttendanceTracker {

    private HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public void markAttendance(String subject, String student) {
        attendance.putIfAbsent(subject, new ArrayList<>());
        ArrayList<String> students = attendance.get(subject);
        if (students.contains(student)) {
            System.out.println(student + " is already marked present for " + subject + ".");
        } else {
            students.add(student);
            System.out.println("Attendance marked: " + student + " -> " + subject);
        }
    }

    public void displayAttendance() {
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
            System.out.println("\n===== Smart Classroom Attendance Tracker =====");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance for All Subjects");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    System.out.print("Enter subject name: ");
                    String subject = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String student = sc.nextLine();
                    tracker.markAttendance(subject, student);
                    break;
                case 2:
                    tracker.displayAttendance();
                    break;
                case 3:
                    System.out.println("Exiting Attendance Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
