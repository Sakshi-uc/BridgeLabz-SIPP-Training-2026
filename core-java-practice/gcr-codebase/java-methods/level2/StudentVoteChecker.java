import java.util.Scanner;

class StudentVoteChecker {
    
    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();
        
        int[] ages = new int[10];
        
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }
        
        System.out.println("\nVoting Eligibility Results:");
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = checker.canStudentVote(ages[i]);
            System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") -> " + (canVote ? "Can Vote" : "Cannot Vote"));
        }
        
        scanner.close();
    }
}
