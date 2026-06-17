import java.util.Scanner;

class BMICalculator {
    
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            data[i][2] = weight / (heightM * heightM);
        }
    }
    
    public static String[] determineBMIStatus(double[][] data) {
        String[] statuses = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmi < 25) {
                statuses[i] = "Normal";
            } else if (bmi < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        return statuses;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] personData = new double[10][3];
        
        for (int i = 0; i < personData.length; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");
            System.out.print("  Weight (kg): ");
            personData[i][0] = scanner.nextDouble();
            System.out.print("  Height (cm): ");
            personData[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(personData);
        String[] statuses = determineBMIStatus(personData);
        
        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for (int i = 0; i < personData.length; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n",
                (i + 1), personData[i][0], personData[i][1], personData[i][2], statuses[i]);
        }
        
        scanner.close();
    }
}
