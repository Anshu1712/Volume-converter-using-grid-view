package com.example.volumeconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class Prism extends AppCompatActivity {

    private TextView textView, textView8 , textView9;
    private EditText numberEt, numberEt2, numberEt3;
    private MaterialButton button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prism);

        // Setup window insets listener for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        textView = findViewById(R.id.textView);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        numberEt = findViewById(R.id.numberEt);
        numberEt2 = findViewById(R.id.numberEt2);
        numberEt3 = findViewById(R.id.numberEt3);
        button = findViewById(R.id.button);

        // Set button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVolume();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculateVolume() {
        String lengthStr = numberEt.getText().toString();
        String widthStr = numberEt2.getText().toString();
        String heightStr = numberEt3.getText().toString();

        if (lengthStr.isEmpty() || widthStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter all dimensions", Toast.LENGTH_SHORT).show();
            return;
        }

        double length = Double.parseDouble(lengthStr);
        double width = Double.parseDouble(widthStr);
        double height = Double.parseDouble(heightStr);

        double surfaceArea = 2 * (length * width + length * height + width * height);

        double volume = length * width * height;

        textView8.setText("Volume is : " + volume);
        textView9.setText("Surface Area is : " + surfaceArea);

        Toast.makeText(getApplicationContext(), "Result is calculated", Toast.LENGTH_SHORT).show();
    }
}
