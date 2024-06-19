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

public class Cube extends AppCompatActivity {

    TextView textView, textView5, textView3;
    EditText numberEt;
    MaterialButton button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView5);
        textView3 = findViewById(R.id.textView3);
        numberEt = findViewById(R.id.numberEt);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String number = numberEt.getText().toString();

                if (number.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the value first", Toast.LENGTH_SHORT).show();
                    return;
                }

                int a = Integer.parseInt(number);

                int volume = a * a * a;
                textView5.setText("volume is : " + volume);

                int surface = 6 * a * a;
                textView3.setText("surface is : " + surface);


                Toast.makeText(getApplicationContext(), "Result is calculated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}