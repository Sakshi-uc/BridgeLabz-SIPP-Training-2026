import java.util.Scanner;

class UnitConverterMisc {
    
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }
    
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Fahrenheit: ");
        double f = scanner.nextDouble();
        System.out.println(f + " F = " + convertFahrenheitToCelsius(f) + " C");
        
        System.out.print("Enter Celsius: ");
        double c = scanner.nextDouble();
        System.out.println(c + " C = " + convertCelsiusToFahrenheit(c) + " F");
        
        System.out.print("Enter pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        
        System.out.print("Enter kilograms: ");
        double kg = scanner.nextDouble();
        System.out.println(kg + " kg = " + convertKilogramsToPounds(kg) + " lbs");
        
        System.out.print("Enter gallons: ");
        double gallons = scanner.nextDouble();
        System.out.println(gallons + " gal = " + convertGallonsToLiters(gallons) + " L");
        
        System.out.print("Enter liters: ");
        double liters = scanner.nextDouble();
        System.out.println(liters + " L = " + convertLitersToGallons(liters) + " gal");
        
        scanner.close();
    }
}
