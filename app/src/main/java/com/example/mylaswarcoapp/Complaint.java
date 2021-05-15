package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Complaint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        //Initialize and assign variable for bottom nav
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);

        // set dashboard selected
        bottomNavigationView.setSelectedItemId(R.id.Bottom_Complaint);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

                switch (menuitem.getItemId()){
                    case R.id.Bottom_Faqs:
                        startActivity(new Intent(getApplicationContext(), Faqs.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Bottom_Dashboard:
                        startActivity(new Intent(getApplicationContext(),
                                Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Bottom_Complaint:

                        return true;

                    case R.id.Bottom_Contact:
                        startActivity(new Intent(getApplicationContext(),
                                Contact.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}