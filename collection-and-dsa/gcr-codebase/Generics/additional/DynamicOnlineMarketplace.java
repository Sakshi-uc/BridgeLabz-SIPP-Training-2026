import java.util.*;

public class DynamicOnlineMarketplace {

    static class BookCategory {
        String genre;

        BookCategory(String genre) {
            this.genre = genre;
        }
    }

    static class ClothingCategory {
        String size;

        ClothingCategory(String size) {
            this.size = size;
        }
    }

    static class GadgetCategory {
        String brand;

        GadgetCategory(String brand) {
            this.brand = brand;
        }
    }

    static class Product<T> {
        String name;
        double price;
        T category;

        Product(String name, double price, T category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String toString() {
            return name + " - $" + price;
        }
    }

    static <T extends Product> void applyDiscount(T product, double percentage) {
        double discountAmount = product.price * (percentage / 100);
        product.price = product.price - discountAmount;
        System.out.println("Discount applied to " + product.name + ". New price: $" + product.price);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Atomic Habits", 20.0, new BookCategory("Self-help"));
        Product<ClothingCategory> shirt = new Product<>("Cotton Shirt", 15.0, new ClothingCategory("M"));
        Product<GadgetCategory> earbuds = new Product<>("Wireless Earbuds", 50.0, new GadgetCategory("SoundX"));

        System.out.println("Before discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(earbuds);

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        applyDiscount(earbuds, 15);

        System.out.println("\nAfter discount:");
        System.out.println(book);
        System.out.println(shirt);
        System.out.println(earbuds);
    }
}
