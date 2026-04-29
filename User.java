public class User {
    private String name;
    private double dailyCalorieGoal;
    private int dailyWaterGoal;
    private int energyLevel;

    public User(String name, double dailyCalorieGoal, int dailyWaterGoal, int energyLevel) {
        this.name = name;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.dailyWaterGoal = dailyWaterGoal;
        this.energyLevel = energyLevel;
    }

    public String getName() {
        return name;
    }

    public double getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public int getDailyWaterGoal() {
        return dailyWaterGoal;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public String getUserSummary() {
        return "User: " + name
                + "\nDaily Calorie Goal: " + dailyCalorieGoal
                + "\nDaily Water Goal: " + dailyWaterGoal + " oz"
                + "\nEnergy Level: " + energyLevel + "/10";
    }
}