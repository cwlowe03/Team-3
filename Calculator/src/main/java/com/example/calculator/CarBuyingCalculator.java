package com.example.assignment4_cis232;

import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

public class CarBuyingCalculator extends Application
{
    public static void main(String[] args)
    {
        //Launch Application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        //Dorm ComboBox
        ComboBox<String> carComboBox = new ComboBox<>();
        carComboBox.getItems().addAll
                (   "Ford Mustang",
                        "Honda CRV",
                        "Toyato Camry",
                        "BMW M3 Sedan"
                );

        //Car Label
        Label carLabel = new Label("Select a car");
        //Create VBOX to hold the Car Label & Car Combo Box
        VBox carVBox = new VBox(10, carLabel,carComboBox);

        //Options ComboBox
        ComboBox<String> optionComboBox = new ComboBox<>();
        optionComboBox.getItems().addAll
                (   "4-Speed Manual",
                        "5-Speed Manual",
                        "Automatic"
                );

        //Option Label
        Label optionLabel = new Label("Select an Option");
        //Create VBOX to hold the Option Label & Option Combo Box
        VBox optionVBox = new VBox(10, optionLabel,optionComboBox);

        HBox optionHBox = new HBox(10, carVBox, optionVBox);

        //Total Cost Label & Output
        Label costDescriptor = new Label("Total Cost: ");
        Label costOutputLabel = new Label("$0.00");
        //Create HBOX to Display the Cost Descriptor & Total Cost Output Side by Side
        HBox costHBox = new HBox(10, costDescriptor,costOutputLabel);
        //Center Position the Cost Descriptor & Total Cost Output
        costHBox.setAlignment(Pos.CENTER);

        //Create Calculate Button
        Button calcButton = new Button("Calculate Total Cost");

        //Event Handler for the Button
        calcButton.setOnAction
                (event ->
                        {
                            double carCharge = 0.0;
                            double optionCharge = 0.0;
                            double totalCharge = 0.0;

                            if (carComboBox.getValue() !=null)
                            {
                                String car = carComboBox.getValue();
                                if (car.equals("Ford Mustang"))
                                    carCharge = 85_800.00;
                                else if (car.equals("Honda CRV"))
                                    carCharge = 52_500.00;
                                else if (car.equals("Toyato Camry"))
                                    carCharge = 65_350.00;
                                else if (car.equals("BMW M3 Sedan"))
                                    carCharge = 100_000.00;
                                else
                                    carCharge = 0.0;
                            }
                            if (optionComboBox.getValue() !=null)
                            {
                                String option = optionComboBox.getValue();
                                if (option.equals("4-Speed Manual"))
                                    optionCharge = 10_000.00;
                                else if (option.equals("5-Speed Manual"))
                                    optionCharge = 20_000.00;
                                else if (option.equals("Automatic"))
                                    optionCharge = 50_000.00;
                                else
                                    optionCharge = 0.0;
                            }

                            //Total Charge calculation
                            totalCharge = carCharge + optionCharge;

                            //Display Charges
                            costOutputLabel.setText(String.format("$%,.2f", totalCharge));
                        }
                );

        // Display in a VBox
        VBox mainVBox = new VBox(10, optionHBox, costHBox, calcButton);
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.setPadding(new Insets(10));

        // Add Main VBox to a scene
        Scene scene = new Scene(mainVBox);

        //Set Scene to Stage & Display
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}