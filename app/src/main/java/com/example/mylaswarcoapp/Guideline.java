package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guideline extends AppCompatActivity  {

    CardView enablelaw, groundwater, drinkingwaterregulation,packagewater, watertanker, penalties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline);

        //Initialize and assign variable for bottom nav
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);

        // set dashboard selected
        bottomNavigationView.setSelectedItemId(R.id.Bottom_Dashboard);

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
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Bottom_Complaint:
                        startActivity(new Intent(getApplicationContext(),Complaint.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Bottom_Contact:
                        startActivity(new Intent(getApplicationContext(),Contact.class));
                        overridePendingTransition(0,0);

                        return true;
                }
                return false;
            }
        });

        enablelaw=findViewById(R.id.card_enablelaw);
        groundwater=findViewById(R.id.card_groundwater);
        packagewater=findViewById(R.id.card_packagewater);
        drinkingwaterregulation=findViewById(R.id.card_drinkingwaterregulation);
        watertanker=findViewById(R.id.card_watertanker);
        penalties=findViewById(R.id.card_penalties);


        enablelaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/enabling-law/");
            }
        });
        drinkingwaterregulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/drinking-water-quality-regulation/");
            }
        });
        groundwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/groundwater-drilling-license-regulation/");
            }
        });
        packagewater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/packaged-water-service-guidelines/");
            }
        });
        watertanker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/water-tanker-practice-order/");
            }
        });
        penalties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://bytes.com.ng/laswarco/offences-and-penalties/");
            }
        });
    }

    private void gotourl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}