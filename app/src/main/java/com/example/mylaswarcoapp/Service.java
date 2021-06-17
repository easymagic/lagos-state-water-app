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

import com.example.mylaswarcoapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Service extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    CardView boreholedrillers, wastewater, wateraudit,boreholepermit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        loadAllNavigations();
        initNavDrawer(this);

        initNavigation();

        init();


    }

    private void init() {

        boreholedrillers=findViewById(R.id.borehole_drillers);
        wastewater=findViewById(R.id.water_waster_treament);
        wateraudit=findViewById(R.id.water_audit);
        boreholepermit=findViewById(R.id.borehole_permit);


        gotoUrlOnClick(boreholedrillers,"https://laswarco.lagosstate.gov.ng/borehole-drillers-license/");

        gotoUrlOnClick(wastewater,"https://laswarco.lagosstate.gov.ng/water-and-wastewater-treatment-plant-certification/");

        gotoUrlOnClick(wateraudit,"https://laswarco.lagosstate.gov.ng/water-use-audit/");

        gotoUrlOnClick(boreholepermit,"https://laswarco.lagosstate.gov.ng/borehole-permit/");

    }


    //



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