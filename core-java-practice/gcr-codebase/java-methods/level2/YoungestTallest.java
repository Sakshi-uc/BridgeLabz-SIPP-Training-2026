import java.util.Scanner;

class YoungestTallest {
    
    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        int index = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngest) {
                youngest = ages[i];
                index = i;
            }
        }
        return index;
    }
    
    public static int findTallest(double[] heights) {
        double tallest = heights[0];
        int index = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallest) {
                tallest = heights[i];
                index = i;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i] + ":");
            System.out.print("  Age: ");
            ages[i] = scanner.nextInt();
            System.out.print("  Height (in cm): ");
            heights[i] = scanner.nextDouble();
        }
        
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);
        
        System.out.println("\nYoungest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
        
        scanner.close();
    }
}
