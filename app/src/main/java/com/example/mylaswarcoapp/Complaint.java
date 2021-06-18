package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.example.mylaswarcoapp.services.ApiService;
import com.example.mylaswarcoapp.services.ComplaintService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

public class Complaint extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complaint);

        loadAllNavigations();

        initNavDrawer(this);

        initNavigation();

        initRequestService();


    }



    void initRequestService(){

        final String[] token = {""};

        ApiService.initContext(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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

                        clearInput(R.id.name);
                        clearInput(R.id.email);
                        clearInput(R.id.phone_number);
                        clearInput(R.id.address);
                        clearInput(R.id.comment);

                    }

                    @Override
                    public void error(String errorMessage) {
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



            }
        });

    }



    @Override
    public void onClick(View v) {

        navigationService.triggerNavigation(v.getId());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        navigationService.triggerNavigation(menuItem.getItemId());

        return true;
    }




}