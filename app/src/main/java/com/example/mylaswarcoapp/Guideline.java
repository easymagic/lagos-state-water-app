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

public class Guideline extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    CardView enablelaw, groundwater, drinkingwaterregulation,packagewater, watertanker, penalties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline);


        initNavigation(R.id.Bottom_Dashboard);

        loadAllNavigations();

        initNavDrawer(this);


        init();


    }

    private void init() {

        enablelaw=findViewById(R.id.card_enablelaw);
        groundwater=findViewById(R.id.card_groundwater);
        packagewater=findViewById(R.id.card_packagewater);
        drinkingwaterregulation=findViewById(R.id.card_drinkingwaterregulation);
        watertanker=findViewById(R.id.card_watertanker);
        penalties=findViewById(R.id.card_penalties);

        gotoUrlOnClick(enablelaw,"https://laswarco.lagosstate.gov.ng/enabling-law/");

        gotoUrlOnClick(drinkingwaterregulation,"https://laswarco.lagosstate.gov.ng/drinking-water-quality-regulation/");

        gotoUrlOnClick(groundwater,"https://laswarco.lagosstate.gov.ng/groundwater-drilling-license-regulation/");

        gotoUrlOnClick(packagewater,"https://laswarco.lagosstate.gov.ng/packaged-water-service-guidelines/");

        gotoUrlOnClick(watertanker,"https://laswarco.lagosstate.gov.ng/water-tanker-practice-order/");

        gotoUrlOnClick(penalties,"https://laswarco.lagosstate.gov.ng/offences-and-penalties/");

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