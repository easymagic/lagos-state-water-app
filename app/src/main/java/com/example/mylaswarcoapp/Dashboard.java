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

        loadAllNavigations();

        initNavDrawer(this);

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

        navigationService.triggerNavigation(v.getId());

    }

    //Navigation clickable function
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        navigationService.triggerNavigation(menuItem.getItemId());

        return true;

    }


}