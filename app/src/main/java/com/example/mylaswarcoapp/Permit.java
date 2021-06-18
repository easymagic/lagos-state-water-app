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

public class Permit extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    CardView bore_hole, drillers, waste_water;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permit);

        init();

        initNavigation();

        loadAllNavigations();

        initNavDrawer(this);

    }

    private void init() {

        bore_hole=findViewById(R.id.app_borehole);
        drillers=findViewById(R.id.app_drillers);
        waste_water=findViewById(R.id.waste_water_card);


        gotoUrlOnClick(bore_hole,"http://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Permit.pdf");

        gotoUrlOnClick(drillers,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Drillers-License.pdf/");

        gotoUrlOnClick(waste_water,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");


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