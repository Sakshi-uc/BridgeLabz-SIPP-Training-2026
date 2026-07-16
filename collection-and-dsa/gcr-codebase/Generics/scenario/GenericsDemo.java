import java.util.*;

public class GenericsDemo {

    static class Pair<T, U> {
        T first;
        U second;

        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    static class Stack<T> {
        private List<T> items = new ArrayList<>();

        void push(T item) {
            items.add(item);
        }

        T pop() {
            if (items.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return items.remove(items.size() - 1);
        }

        T peek() {
            if (items.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return items.get(items.size() - 1);
        }

        boolean isEmpty() {
            return items.isEmpty();
        }

        int size() {
            return items.size();
        }
    }

    static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    static class Repository<T> {
        private List<T> entities = new ArrayList<>();

        void add(T entity) {
            entities.add(entity);
        }

        T get(int index) {
            return entities.get(index);
        }

        List<T> getAll() {
            return entities;
        }

        int count() {
            return entities.size();
        }
    }

    static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println("Pair: " + pair);

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());

        Integer[] numbers = {4, 9, 1, 7, 3};
        System.out.println("Max number: " + findMax(numbers));

        String[] names = {"Zara", "Amit", "Neha"};
        System.out.println("Max name: " + findMax(names));

        Repository<String> repo = new Repository<>();
        repo.add("Book");
        repo.add("Laptop");
        repo.add("Chair");
        System.out.println("Repository count: " + repo.count());

        System.out.println("Printing repository items using wildcard method:");
        printList(repo.getAll());
    }
}
