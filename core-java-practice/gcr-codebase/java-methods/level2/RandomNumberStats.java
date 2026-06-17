class RandomNumberStats {
    
    public int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return numbers;
    }
    
    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
    
    public static void main(String[] args) {
        RandomNumberStats stats = new RandomNumberStats();
        
        int[] randomNumbers = stats.generate4DigitRandomArray(5);
        
        System.out.print("Generated 4-digit random numbers: ");
        for (int number : randomNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        
        double[] results = stats.findAverageMinMax(randomNumbers);
        
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}
