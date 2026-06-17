public class FootballTeamHeights {
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        for (int index = 0; index < heights.length; index++) {
            heights[index] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    public static int findSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void displayHeights(int[] heights) {
        System.out.println("Player\tHeight(cm)");
        for (int index = 0; index < heights.length; index++) {
            System.out.println((index + 1) + "\t" + heights[index]);
        }
    }

    public static void main(String[] args) {
        int[] heights = generateHeights(11);
        displayHeights(heights);
        System.out.println("\nShortest height: " + findShortest(heights) + " cm");
        System.out.println("Tallest height: " + findTallest(heights) + " cm");
        System.out.printf("Mean height: %.2f cm%n", findMean(heights));
    }
}
