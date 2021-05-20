package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TestingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        initNavigation();
//        selectItem(R.id.Bottom_Dashboard);

//        //Initialize and assign variable for bottom nav
//        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
//
//        // set dashboard selected
//        bottomNavigationView.setSelectedItemId(R.id.Bottom_Dashboard);
//
//        // Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
//
//                switch (menuitem.getItemId()){
//                    case R.id.Bottom_Faqs:
//                        startActivity(new Intent(getApplicationContext(), Faqs.class));
//                        overridePendingTransition(0,0);
//                        return true;
//
//                    case R.id.Bottom_Dashboard:
//                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                    case R.id.Bottom_Complaint:
//                        startActivity(new Intent(getApplicationContext(),Complaint.class));
//                        overridePendingTransition(0,0);
//                        return true;
//
//                    case R.id.Bottom_Contact:
//                        startActivity(new Intent(getApplicationContext(),Contact.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

    }


}