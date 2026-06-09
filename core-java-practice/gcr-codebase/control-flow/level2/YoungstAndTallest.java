import java.util.Scanner;

public class YoungstAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Amar's height: ");
        double amarHt = sc.nextDouble();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Akbar's height: ");
        double akbarHt = sc.nextDouble();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Anthony's height: ");
        double anthonyHt = sc.nextDouble();

        String youngest;
        if(amarAge<=akbarAge && amarAge<=anthonyAge) {
            youngest = "Amar";
        } else if(akbarAge<=amarAge && akbarAge<=anthonyAge) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }

        String tallest;
        if(amarHt>=akbarHt && amarHt>=anthonyHt) {
            tallest = "Amar";
        } else if(akbarHt>=amarHt && akbarHt>=anthonyHt) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }

        System.out.println("The youngest friend is " + youngest);
        System.out.println("The tallest friend is " + tallest);
    }
}
