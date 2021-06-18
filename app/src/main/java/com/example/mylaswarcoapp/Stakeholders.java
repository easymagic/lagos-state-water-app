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

public class Stakeholders extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    CardView municipal, water_tanker, bore_hole, package_water, wastewater_treat;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stakeholders);

        init();
        initNavigation();

        initNavDrawer(this);
        loadAllNavigations();

    }

    private void init() {

        municipal=findViewById(R.id.card_municipal);
        water_tanker=findViewById(R.id.card_watertanker);
        bore_hole=findViewById(R.id.card_boreholedrillers);
        package_water=findViewById(R.id.card_package_water);
        wastewater_treat=findViewById(R.id.card_wastewater);


        gotoUrlOnClick(municipal,"http://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Permit.pdf");

        gotoUrlOnClick(water_tanker,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Drillers-License.pdf/");

        gotoUrlOnClick(bore_hole,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");

        gotoUrlOnClick(package_water,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");

        gotoUrlOnClick( wastewater_treat,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");


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