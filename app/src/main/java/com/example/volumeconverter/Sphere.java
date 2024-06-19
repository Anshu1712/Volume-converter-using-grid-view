package com.example.volumeconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class Sphere extends AppCompatActivity {

    EditText numberEt;
    TextView textView, textView3 , textView4;
    MaterialButton button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numberEt = findViewById(R.id.numberEt);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String radius = numberEt.getText().toString();
                if (radius.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter the radius value first",Toast.LENGTH_SHORT).show();
                    return;
                }
                int r = Integer.parseInt(radius);
                // V = (4/3)* pi * r^3

                double volume = ((double) 4 /3) * 3.14159 * r * r * r;
                textView3.setText("Volume is : " +volume+ " m^3");

                double surfaceArea = 4 * 3.14159 * r * r;
                textView4.setText("SurfaceArea is : " +surfaceArea+ " m^2");

                Toast.makeText(getApplicationContext(), "Result is calculated", Toast.LENGTH_SHORT).show();

            }
        });
    }
}