package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Contact extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initNavigation();

        selectItem(R.id.Bottom_Contact);

    }

}