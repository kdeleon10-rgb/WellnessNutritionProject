import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WellnessNutritionApp extends Application {

    private TextField foodNameField;
    private TextField categoryField;
    private TextField caloriesField;
    private TextField nutrientsField;
    private TextField quantityField;
    private TextField waterField;
    private TextArea outputArea;

    private Tracker tracker = new Tracker();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Wellness and Nutrition Tracker");

        Label titleLabel = new Label("Wellness and Nutrition Tracker");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        foodNameField = new TextField();
        foodNameField.setPromptText("Food name");

        categoryField = new TextField();
        categoryField.setPromptText("Category");

        caloriesField = new TextField();
        caloriesField.setPromptText("Calories");

        nutrientsField = new TextField();
        nutrientsField.setPromptText("Nutrients");

        quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        waterField = new TextField();
        waterField.setPromptText("Water intake in ounces");

        Button logFoodButton = new Button("Log Food");
        Button logWaterButton = new Button("Log Water");
        Button summaryButton = new Button("Show Summary");
        Button clearButton = new Button("Clear");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        logFoodButton.setOnAction(e -> logFood());
        logWaterButton.setOnAction(e -> logWater());
        summaryButton.setOnAction(e -> showSummary());
        clearButton.setOnAction(e -> clearFields());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(
                titleLabel,
                new Label("Food Information"),
                foodNameField,
                categoryField,
                caloriesField,
                nutrientsField,
                quantityField,
                logFoodButton,
                new Label("Water Information"),
                waterField,
                logWaterButton,
                summaryButton,
                clearButton,
                new Label("Output"),
                outputArea
        );

        Scene scene = new Scene(layout, 450, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void logFood() {
        try {
            String name = foodNameField.getText();
            String category = categoryField.getText();
            double calories = Double.parseDouble(caloriesField.getText());
            String nutrients = nutrientsField.getText();
            int quantity = Integer.parseInt(quantityField.getText());

            if (name.isEmpty() || category.isEmpty() || nutrients.isEmpty()) {
                outputArea.setText("Please fill in all food fields.");
                return;
            }

            if (calories < 0 || quantity <= 0) {
                outputArea.setText("Calories cannot be negative and quantity must be greater than 0.");
                return;
            }

            FoodItem food = new FoodItem(name, category, calories, nutrients, quantity);
            tracker.addFood(food);

            outputArea.setText("Food logged successfully!\n\n" + food.getDetails());

        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter valid numbers for calories and quantity.");
        }
    }

    private void logWater() {
        try {
            int ounces = Integer.parseInt(waterField.getText());

            if (ounces <= 0) {
                outputArea.setText("Water amount must be greater than 0.");
                return;
            }

            tracker.addWater(ounces);
            outputArea.setText("Water logged successfully!\n\nWater added: " + ounces + " oz");

        } catch (NumberFormatException ex) {
            outputArea.setText("Please enter a valid number for water.");
        }
    }

    private void showSummary() {
        outputArea.setText(tracker.getSummary());
    }

    private void clearFields() {
        foodNameField.clear();
        categoryField.clear();
        caloriesField.clear();
        nutrientsField.clear();
        quantityField.clear();
        waterField.clear();
        outputArea.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}