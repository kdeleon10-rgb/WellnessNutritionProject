public abstract class Consumable {
    private String name;
    private String category;
    private double calories;

    public Consumable(String name, String category, double calories) {
        this.name = name;
        this.category = category;
        setCalories(calories);
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        if (calories >= 0) {
            this.calories = calories;
        } else {
            System.out.println("Calories cannot be negative.");
        }
    }

    public abstract String getDetails();
}