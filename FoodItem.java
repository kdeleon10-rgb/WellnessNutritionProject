
public class FoodItem extends Consumable {

    private String nutrients;
    private int quantity;

    public FoodItem(String name, String category, double calories, String nutrients, int quantity) {
        super(name, category, calories);
        this.nutrients = nutrients;
        this.quantity = quantity;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity must be greater than 0.");
        }
    }

    @Override
    public String getDetails() {
        return "Food Item: " + getName()
                + "\nCategory: " + getCategory()
                + "\nCalories: " + getCalories()
                + "\nNutrients: " + nutrients
                + "\nQuantity: " + quantity;
    }
}
