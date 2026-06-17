public class EmployeeBonus {
    public static int[][] generateSalaryAndServiceYears(int employees) {
        int[][] salaryAndService = new int[employees][2];
        for (int row = 0; row < employees; row++) {
            salaryAndService[row][0] = (int) (Math.random() * 90000) + 10000;
            salaryAndService[row][1] = (int) (Math.random() * 10) + 1;
        }
        return salaryAndService;
    }

    public static double[][] calculateNewSalaryAndBonus(int[][] salaryAndService) {
        double[][] salaryAndBonus = new double[salaryAndService.length][2];
        for (int row = 0; row < salaryAndService.length; row++) {
            double oldSalary = salaryAndService[row][0];
            int yearsOfService = salaryAndService[row][1];
            double bonusRate = yearsOfService > 5 ? 0.05 : 0.02;
            double bonus = oldSalary * bonusRate;
            salaryAndBonus[row][0] = oldSalary + bonus;
            salaryAndBonus[row][1] = bonus;
        }
        return salaryAndBonus;
    }

    public static void displaySalaryReport(int[][] salaryAndService, double[][] salaryAndBonus) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        for (int row = 0; row < salaryAndService.length; row++) {
            double oldSalary = salaryAndService[row][0];
            double bonus = salaryAndBonus[row][1];
            double newSalary = salaryAndBonus[row][0];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%d\t%.2f\t\t%d\t%.2f\t\t%.2f%n",
                    row + 1, oldSalary, salaryAndService[row][1], bonus, newSalary);
        }

        System.out.printf("%nTotal old salary: %.2f%n", totalOldSalary);
        System.out.printf("Total bonus amount: %.2f%n", totalBonus);
        System.out.printf("Total new salary: %.2f%n", totalNewSalary);
    }

    public static void main(String[] args) {
        int[][] salaryAndService = generateSalaryAndServiceYears(10);
        double[][] salaryAndBonus = calculateNewSalaryAndBonus(salaryAndService);
        displaySalaryReport(salaryAndService, salaryAndBonus);
    }
}
