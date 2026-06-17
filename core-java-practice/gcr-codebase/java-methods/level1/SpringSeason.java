class SpringSeason {
    public boolean isSpringSeason(int month, int day) {
        return (month == 3 && day >= 20) || (month == 4 || month == 5) || (month == 6 && day <= 20);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        SpringSeason springSeason = new SpringSeason();
        boolean isSpring = springSeason.isSpringSeason(month, day);

        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}
