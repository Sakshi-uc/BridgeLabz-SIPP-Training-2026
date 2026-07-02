import java.util.*;

public class PersonalizedMealPlanGenerator {

    interface MealPlan {
        String getPlanName();
    }

    static class VegetarianMeal implements MealPlan {
        public String getPlanName() {
            return "Vegetarian Meal Plan";
        }
    }

    static class VeganMeal implements MealPlan {
        public String getPlanName() {
            return "Vegan Meal Plan";
        }
    }

    static class KetoMeal implements MealPlan {
        public String getPlanName() {
            return "Keto Meal Plan";
        }
    }

    static class HighProteinMeal implements MealPlan {
        public String getPlanName() {
            return "High-Protein Meal Plan";
        }
    }

    static class Meal<T extends MealPlan> {
        T plan;
        List<String> items = new ArrayList<>();

        Meal(T plan) {
            this.plan = plan;
        }

        void addItem(String item) {
            items.add(item);
        }

        void display() {
            System.out.println(plan.getPlanName() + ":");
            for (String item : items) {
                System.out.println("   - " + item);
            }
        }
    }

    static <T extends MealPlan> Meal<T> generatePlan(T plan, String... items) {
        Meal<T> meal = new Meal<>(plan);
        for (String item : items) {
            meal.addItem(item);
        }
        return meal;
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = generatePlan(new VegetarianMeal(), "Paneer curry", "Rice", "Salad");
        Meal<VeganMeal> veganMeal = generatePlan(new VeganMeal(), "Tofu stir fry", "Quinoa", "Steamed veggies");
        Meal<KetoMeal> ketoMeal = generatePlan(new KetoMeal(), "Grilled chicken", "Avocado", "Cheese");
        Meal<HighProteinMeal> proteinMeal = generatePlan(new HighProteinMeal(), "Egg whites", "Protein shake", "Almonds");

        vegMeal.display();
        veganMeal.display();
        ketoMeal.display();
        proteinMeal.display();
    }
}
