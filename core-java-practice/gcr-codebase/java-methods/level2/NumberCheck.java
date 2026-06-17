import java.util.Scanner;

class NumberCheck {
    
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        System.out.println("\nResults:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + " (" + numbers[i] + "): ");
            if (isPositive(numbers[i])) {
                System.out.print("Positive, ");
                if (isEven(numbers[i])) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }
        
        int comparison = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("\nFirst element (" + numbers[0] + ") vs Last element (" + numbers[numbers.length - 1] + "): ");
        if (comparison == 1) {
            System.out.println("First is greater");
        } else if (comparison == 0) {
            System.out.println("Both are equal");
        } else {
            System.out.println("First is lesser");
        }
        
        scanner.close();
    }
}
