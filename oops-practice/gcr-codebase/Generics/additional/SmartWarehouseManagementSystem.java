import java.util.*;

public class SmartWarehouseManagementSystem {

    static abstract class WarehouseItem {
        String itemName;

        WarehouseItem(String itemName) {
            this.itemName = itemName;
        }

        public String toString() {
            return getClass().getSimpleName() + ": " + itemName;
        }
    }

    static class Electronics extends WarehouseItem {
        Electronics(String itemName) {
            super(itemName);
        }
    }

    static class Groceries extends WarehouseItem {
        Groceries(String itemName) {
            super(itemName);
        }
    }

    static class Furniture extends WarehouseItem {
        Furniture(String itemName) {
            super(itemName);
        }
    }

    static class Storage<T extends WarehouseItem> {
        private List<T> items = new ArrayList<>();

        void addItem(T item) {
            items.add(item);
            System.out.println("Added to storage: " + item);
        }

        List<T> getItems() {
            return items;
        }
    }

    static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("\n--- Warehouse Inventory ---");
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));

        displayAllItems(electronicsStorage.getItems());
        displayAllItems(groceriesStorage.getItems());
        displayAllItems(furnitureStorage.getItems());
    }
}
