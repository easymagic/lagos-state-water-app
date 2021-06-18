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
import com.example.mylaswarcoapp.services.NavigationService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class About extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


//    NavigationService navigationService = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        loadAllNavigations();

        initNavDrawer(this);

        initNavigation();

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