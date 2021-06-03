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
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Contact extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //init();
        initNavigation();

//        selectItem(R.id.Bottom_Dashboard);


        //Variables
        DrawerLayout drawerLayout;
        Toolbar toolbar;
        NavigationView navigationView;

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);

        //Toolbar
        setSupportActionBar(toolbar);


        //Navigation Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.naigation_drawer_open, R.string.naigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Clickable Menu
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void init() {
    }


    //



    @Override
    public void onClick(View v) {
//        Intent i;
        switch (v.getId()) {

            case R.id.about_card:


                loadActivity(About.class);

                break;

            case R.id.service_card:

//                Intent i = new Intent(this,Service.class);
//                startActivity(i);

                loadActivity(Service.class);

                break;

            case R.id.permit_card:

                loadActivity(Permit.class);

                break;
            case R.id.guideline_card:

                loadActivity(Guideline.class);

                break;

            case R.id.stakeholders_card:

                loadActivity(Stakeholders.class);

                break;
            case R.id.testing_card:

                loadActivity(TestingActivity.class);

                break;
            default:
                break;
        }

    }

    //Navigation clickable function
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

       /* switch (menuItem.getItemId()){

            case R.id.nav_home:
                Intent intent6=new Intent(Dashboard.this,Dashboard.class);
                startActivity(intent6);
                break;
                case R.id.nav_about:
                    Intent intent1=new Intent(Dashboard.this, About.class);
                    startActivity(intent1);
                break;
            case R.id.nav_complaint:
                Intent intent=new Intent(Dashboard.this,Complaint.class);
                startActivity(intent);
                break;

            case R.id.nav_guild:
                Intent intent2=new Intent(Dashboard.this,Guideline.class);
                startActivity(intent2);
                break;
            case R.id.nav_stakeholders:
                Intent intent3=new Intent(Dashboard.this,Stakeholders.class);
                startActivity(intent3);
                break;
            case R.id.nav_permit:
                Intent intent4=new Intent(Dashboard.this,Complaint.class);
                startActivity(intent4);
                break;
            case R.id.nav_service:
                Intent intent5=new Intent(Dashboard.this,Complaint.class);
                startActivity(intent5);
                break; */

        int id = menuItem.getItemId();

        if (id==R.id.nav_about) {

            loadActivity(About.class);

        }

        if (id==R.id.nav_service){

            loadActivity(Service.class);

        }

        if (id==R.id.nav_permit) {

            loadActivity(Permit.class);

        }

        if (id==R.id.nav_guild){

            loadActivity(Guideline.class);

        }

        if (id==R.id.nav_stakeholders){

            loadActivity(Stakeholders.class);

        }


        if (id==R.id.nav_testing){


            loadActivity(TestingActivity.class);

        }

        if (id==R.id.nav_home){

            loadActivity(Dashboard.class);

        }

        return true;
    }





   /** void init(){

        initModule();


        ApiService.initContext(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] token = {""};

                ContactService.send(new ApiService.PayloadInterface() {
                    @Override
                    public ApiService.PayLoadData getPayload(ApiService.PayLoadData payLoadData) {




                        payLoadData.set("name",getInput(R.id.name));
                        payLoadData.set("email",getInput(R.id.email));
                        payLoadData.set("phone_number",getInput(R.id.phone_number));
//                        payLoadData.set("address",getInput(R.id.address));
                        payLoadData.set("comment",getInput(R.id.comment));
                        payLoadData.set("type","feedback");


                        return payLoadData;

                    }

                    @Override
                    public void completed(JSONObject jsonObject) {

                        showMessage(jsonObject.optString("message"));

                        clearInput(R.id.name);
                        clearInput(R.id.email);
                        clearInput(R.id.phone_number);
                        clearInput(R.id.comment);

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



            }
        });

    }*/

}