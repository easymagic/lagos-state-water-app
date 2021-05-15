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

public class Permit extends AppCompatActivity  {

    CardView bore_hole, drillers, waste_water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permit);

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

        bore_hole=findViewById(R.id.app_borehole);
        drillers=findViewById(R.id.app_drillers);
        waste_water=findViewById(R.id.waste_water_card);



        bore_hole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("http://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Permit.pdf");
            }
        });
        drillers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Drillers-License.pdf/");
            }
        });
        waste_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");
            }
        });

    }

    private void gotourl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}