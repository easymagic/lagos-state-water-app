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

public class Permit extends BaseActivity {

    CardView bore_hole, drillers, waste_water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permit);

        initNavigation();
//        selectItem(R.id.Bottom_Dashboard);

        bore_hole=findViewById(R.id.app_borehole);
        drillers=findViewById(R.id.app_drillers);
        waste_water=findViewById(R.id.waste_water_card);

        gotoUrlOnClick(bore_hole,"http://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Permit.pdf");

        gotoUrlOnClick(drillers,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Borehole-Drillers-License.pdf/");

        gotoUrlOnClick(waste_water,"https://laswarco.lagosstate.gov.ng/wp-content/uploads/2021/02/Application-for-Water-Wastewater-Treatment-Plant-License.pdf/");

    }


}