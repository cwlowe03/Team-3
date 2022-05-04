package com.example.alexassignment7classes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 Basic Class set up to be used for Assignment 7.  it is going to end up being changed from current state to fit Project's
 needs.
 @author Alex Wagner
 */


public class AlexProjectClasses extends Application {
    @Override

    public void start(Stage stage)
    {
        ComboBox<String> dormCombo = new ComboBox<>();
        dormCombo.getItems().addAll("Allen Hall", "Pike Hall", "Farthing Hall", "University Suites");

        Label dormLabel = new Label("Select a dorm to stay in");

        ComboBox<String> mealCombo = new ComboBox<>();
        mealCombo.getItems().addAll("7 meals per week", "14 meals per week", "Unlimited meals");

        Label mealLabel = new Label("Select a meal plan");

        Label totalLabel = new Label("Total Cost");

        Label costLabel = new Label("0");

        Button costButton = new Button("Calculate costs");
        costButton.setOnAction(event ->
                {
                    double dormCost = 0.0;
                    double mealCost = 0.0;
                    double total = 0.0;
                    if (dormCombo.getValue() != null) {
                        String dormSelection = dormCombo.getValue();
                        if (dormSelection.equals("Allen Hall"))
                            dormCost = 1800.00;
                        else if (dormSelection.equals("Pike Hall"))
                            dormCost = 2200.00;
                        else if (dormSelection.equals("Farthing Hall"))
                            dormCost = 2800.00;
                        else if (dormSelection.equals("University Suites"))
                            dormCost = 3000.00;
                        else dormCost = 0.0;


                    }
                    if (mealCombo.getValue() != null) {
                        String mealSelection = mealCombo.getValue();
                        if (mealSelection.equals("7 meals per week"))
                            mealCost = 600.00;
                        else if (mealSelection.equals("14 meals per week"))
                            mealCost = 1100.00;
                        else if (mealSelection.equals("Unlimited meals"))
                            mealCost = 1800.00;
                        else mealCost = 0.0;

                    }
                    total = mealCost + dormCost;
                    costLabel.setText(String.valueOf(total));

                }
        );

        VBox vBox = new VBox( 10, dormCombo,dormLabel,mealCombo,mealLabel,costButton, totalLabel, costLabel);
        vBox.setAlignment(Pos.CENTER);






        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);

        stage.show();
    }

}