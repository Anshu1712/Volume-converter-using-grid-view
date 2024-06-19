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

public class Cylinder extends AppCompatActivity {

    TextView textView, textView7 ,textView10;
    EditText numberEt, numberEt2;
    MaterialButton button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cylinder);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView);
        textView7 = findViewById(R.id.textView7);
        textView10 = findViewById(R.id.textView10);
        numberEt = findViewById(R.id.numberEt);
        numberEt2 = findViewById(R.id.numberEt2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String number = numberEt.getText().toString();
                String number2 = numberEt2.getText().toString();

                if (number.isEmpty() || number2.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter both radius and height", Toast.LENGTH_SHORT).show();
                    return;
                }

                double radius = Double.parseDouble(number);
                double height = Double.parseDouble(number2);

                int volume = (int) (Math.PI * radius * radius * height);

                double surfaceArea = 2 * Math.PI * radius * (radius + height);

                textView7.setText("Surface Area is : " + surfaceArea);
                textView10.setText("Volume is : " + volume);

                Toast.makeText(getApplicationContext(), "Result is calculated", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
