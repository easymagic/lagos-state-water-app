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
<<<<<<< HEAD
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
=======
            public void onClick(View v) {

                final String[] token = {""};

                ComplaintService.send(new ApiService.PayloadInterface() {
                    @Override
                    public ApiService.PayLoadData getPayload(ApiService.PayLoadData payLoadData) {

                        payLoadData.set("name",getInput(R.id.name));
                        payLoadData.set("email",getInput(R.id.email));
                        payLoadData.set("phone_number",getInput(R.id.phone_number));
                        payLoadData.set("address",getInput(R.id.address));
                        payLoadData.set("comment",getInput(R.id.comment));


                        return payLoadData;

                    }

                    @Override
                    public void completed(JSONObject jsonObject) {

                        showMessage(jsonObject.optString("message"));

                    }

                    @Override
                    public void error(String errorMessage){

                        showMessage(errorMessage);

                    }

                    @Override
                    public void loadStart() {

                        loadStart_();

                    }

                    @Override
                    public void loadStop() {

                        loadStop_();

                    }

                    @Override
                    public String getBearerToken() {
                        return token[0];
                    }

                    @Override
                    public void setBearerToken(String token_) {
                       token[0] = token_;
                    }
                });



>>>>>>> d4a4a387efc2d419b694cd5ba7a3f024f3438a82
            }
        });
    }
}