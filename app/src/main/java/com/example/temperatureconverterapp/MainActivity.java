package com.example.temperatureconverterapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editTextCelsius;
    private Button buttonConvert;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        // Set click listener for the convert button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        // Get the input Celsius temperature
        String celsiusString = editTextCelsius.getText().toString().trim();

        if (!celsiusString.isEmpty()) {
            try {
                // Parse the Celsius temperature to double
                double celsius = Double.parseDouble(celsiusString);

                // Convert Celsius to Fahrenheit
                double fahrenheit = celsius * 9 / 5 + 32;

                // Display the result
                String result = String.format("%.2f Fahrenheit", fahrenheit);
                textViewResult.setText(result);
            } catch (NumberFormatException e) {
                textViewResult.setText("Invalid input");
            }
        } else {
            textViewResult.setText("Enter a temperature");
        }
    }
}
