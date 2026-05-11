public class DrinkItem extends Consumable {

    private int ounces;
    private boolean hasCaffeine;

    public DrinkItem(String name, String category, double calories, int ounces, boolean hasCaffeine) {
        super(name, category, calories);
        setOunces(ounces);
        this.hasCaffeine = hasCaffeine;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        if (ounces > 0) {
            this.ounces = ounces;
        } else {
            System.out.println("Ounces must be greater than 0.");
        }
    }

    public boolean hasCaffeine() {
        return hasCaffeine;
    }

    public void setHasCaffeine(boolean hasCaffeine) {
        this.hasCaffeine = hasCaffeine;
    }

    @Override
    public String getDetails() {
        return "Drink Item: " + getName()
                + "\nCategory: " + getCategory()
                + "\nCalories: " + getCalories()
                + "\nOunces: " + ounces
                + "\nHas Caffeine: " + hasCaffeine;
    }
}