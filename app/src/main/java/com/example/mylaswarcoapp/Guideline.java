package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guideline extends BaseActivity {

    CardView enablelaw, groundwater, drinkingwaterregulation,packagewater, watertanker, penalties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline);

        initNavigation();

//        selectItem(R.id.Bottom_Dashboard);

        enablelaw=findViewById(R.id.card_enablelaw);
        groundwater=findViewById(R.id.card_groundwater);
        packagewater=findViewById(R.id.card_packagewater);
        drinkingwaterregulation=findViewById(R.id.card_drinkingwaterregulation);
        watertanker=findViewById(R.id.card_watertanker);
        penalties=findViewById(R.id.card_penalties);

        gotoUrlOnClick(enablelaw,"http://bytes.com.ng/laswarco/enabling-law/");

        gotoUrlOnClick(drinkingwaterregulation,"http://bytes.com.ng/laswarco/drinking-water-quality-regulation/");

        gotoUrlOnClick(groundwater,"http://bytes.com.ng/laswarco/groundwater-drilling-license-regulation/");

        gotoUrlOnClick(packagewater,"http://bytes.com.ng/laswarco/packaged-water-service-guidelines/");

        gotoUrlOnClick(watertanker,"http://bytes.com.ng/laswarco/water-tanker-practice-order/");

        gotoUrlOnClick(penalties,"http://bytes.com.ng/laswarco/offences-and-penalties/");

    }



}