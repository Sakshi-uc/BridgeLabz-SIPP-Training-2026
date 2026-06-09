import java.util.Scanner;
public class HeightConverter {
    public static void main(String[] args) {
        double heightCm;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        heightCm = sc.nextDouble();
        double heightInches = heightCm/2.54;
        double heightFeet = heightInches/12;
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + heightFeet + " and inches is " + heightInches);
    }
}