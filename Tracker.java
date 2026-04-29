public class Tracker {
    private double totalCalories;
    private int totalWater;

    public Tracker() {
        totalCalories = 0;
        totalWater = 0;
    }

    public void addFood(FoodItem food) {
        totalCalories += food.getCalories() * food.getQuantity();
    }

    public void addWater(int ounces) {
        if (ounces > 0) {
            totalWater += ounces;
        } else {
            System.out.println("Water must be greater than 0.");
        }
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public int getTotalWater() {
        return totalWater;
    }

    public String getSummary() {
        return "Daily Summary"
                + "\nTotal Calories: " + totalCalories
                + "\nTotal Water: " + totalWater + " oz";
    }
}