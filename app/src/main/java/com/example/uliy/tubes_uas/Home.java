package com.example.uliy.tubes_uas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Home extends AppCompatActivity {
    Button buttonLogout, btnmap, btnfasilitas, btndes;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sessionManagement = new SessionManagement(Home.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Logout menuju class session management
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagement.logoutUser();
            }
        });

        Button gmaps = (Button) findViewById(R.id.butgmaps);

        gmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.google.com/maps/place/Jawa+Timur+Park+1/@-7.8839149,112.522593,17z/data=!3m1!4b1!4m5!3m4!1s0x2e78872ad61d07b9:0x59a848ad52479780!8m2!3d-7.8839149!4d112.5247817"));
                startActivity(i);
            }
        });
        btndes = (Button) findViewById(R.id.butdeskripsi);
        btndes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Galeri.class);
                startActivity(i);
                finish();
            }
        });
        btnfasilitas = (Button) findViewById(R.id.butfasilitas);
        btnfasilitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fasilitas.class);
                startActivity(i);
                finish();
            }
        });
    }
}