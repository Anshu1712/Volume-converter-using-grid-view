package com.example.volumeconverter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapes;

    MyAdapters adapters;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = findViewById(R.id.gridView);
        shapes = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere, "Sphere");
        Shape s2 = new Shape(R.drawable.cylinder, "Cylinder");
        Shape s3 = new Shape(R.drawable.cube, "Cube");
        Shape s4 = new Shape(R.drawable.prism, "Prism");

        shapes.add(s1);
        shapes.add(s2);
        shapes.add(s3);
        shapes.add(s4);

        adapters = new MyAdapters(shapes, getApplicationContext());

        gridView.setAdapter(adapters);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(MainActivity.this, Sphere.class);
                    startActivity(i);
                } else if (position == 1) {
                    Intent a = new Intent(MainActivity.this, Cylinder.class);
                    startActivity(a);
                } else if (position == 2) {
                    Intent b = new Intent(MainActivity.this, Cube.class);
                    startActivity(b);
                } else if (position == 3) {
                    Intent c = new Intent(MainActivity.this, Prism.class);
                    startActivity(c);
                }
            }
        });
    }
}