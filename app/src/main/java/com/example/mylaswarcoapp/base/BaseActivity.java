package com.example.mylaswarcoapp.base;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mylaswarcoapp.Contact;
import com.example.mylaswarcoapp.Dashboard;
import com.example.mylaswarcoapp.Faqs;
import com.example.mylaswarcoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView = null;

    public void initNavigation(){
        bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                return navSelected(item);
            }

        });
    }

    public void selectItem(int item){
        bottomNavigationView.setSelectedItemId(item);
    }



    public boolean navSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId()) {
            case R.id.Bottom_Faqs:
                startActivity(new Intent(getApplicationContext(), Faqs.class));
                overridePendingTransition(0, 0);
                return true;

            case R.id.Bottom_Dashboard:
                startActivity(new Intent(getApplicationContext(),
                        Dashboard.class));
                overridePendingTransition(0, 0);
                return true;
            case R.id.Bottom_Complaint:

                return true;

            case R.id.Bottom_Contact:
                startActivity(new Intent(getApplicationContext(),
                        Contact.class));
                overridePendingTransition(0, 0);
                return true;
        }
        return false;
    }


    private void gotourl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void gotoUrlOnClick(CardView cardView, String url){

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotourl(url);

            }
        });

    }




}