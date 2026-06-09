public class Discount{
    public static void main(String[] args) {
        double fees = 125000;
        double discountPerc = 10;
        double discount = fees*discountPercent/100;
        double finalFees = fees-discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFees);
    }
}