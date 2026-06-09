import java.util.Scanner;

public class DiscountedFee {
    public static void main(String[] args) {
        double fees;
        double discountPerc;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the fees: ");
        fees = sc.nextDouble();
        System.out.print("Enter the discount percent: ");
        discountPerc = sc.nextDouble();
        double discount = fees * discountPerc / 100;
        double finalFees = fees - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFees);
    }
}