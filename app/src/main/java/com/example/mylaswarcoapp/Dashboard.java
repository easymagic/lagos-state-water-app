package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    CardView about, service, permit, guideline, stakeholders, complaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_dashboard);


        init();

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


    //
    void init() {

        about = (CardView) findViewById(R.id.about_card);
        service = (CardView) findViewById(R.id.service_card);
        permit = (CardView) findViewById(R.id.permit_card);
        guideline = (CardView) findViewById(R.id.guideline_card);
        stakeholders = (CardView) findViewById(R.id.stakeholders_card);
        complaint = (CardView) findViewById(R.id.testing_card);

        //Add listener to the card

        about.setOnClickListener(this);
        service.setOnClickListener(this);
        permit.setOnClickListener(this);
        guideline.setOnClickListener(this);
        stakeholders.setOnClickListener(this);
        complaint.setOnClickListener(this);


    }


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

}