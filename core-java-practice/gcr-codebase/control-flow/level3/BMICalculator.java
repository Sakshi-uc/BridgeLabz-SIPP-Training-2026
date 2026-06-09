import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        double wt = sc.nextDouble();
        System.out.print("Enter height (cm): ");
        double ht = sc.nextDouble();

        double htM = ht/100;
        double bmi = wt/(htM*htM);
        String status;

        if(bmi<=18.4) {
            status = "Underweight";
        } else if(bmi<=24.9) {
            status = "Normal";
        } else if(bmi<=39.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("BMI: " + bmi);
        System.out.println("Status: " + status);
    }
}
