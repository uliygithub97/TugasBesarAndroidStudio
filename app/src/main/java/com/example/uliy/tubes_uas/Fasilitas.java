package com.example.uliy.tubes_uas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Fasilitas extends AppCompatActivity {
    private Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasilitas);

        myButton = (Button) findViewById(R.id.ButtonShuttleCar);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Fasilitas.this, ShuttleCar.class);
                startActivity(i);
            }
        });

        myButton = (Button) findViewById(R.id.ButtonFoodCourt);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Fasilitas.this, FoodCourt.class);
                startActivity(i);
            }
        });

        myButton = (Button) findViewById(R.id.ButtonMedical);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Fasilitas.this, MedicalCare.class);
                startActivity(i);
            }
        });

        myButton = (Button) findViewById(R.id.ButtonCharging);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Fasilitas.this, Charging.class);
                startActivity(i);
            }
        });

        myButton = (Button) findViewById(R.id.btnhome1);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (Fasilitas.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
