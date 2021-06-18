package com.example.mylaswarcoapp.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.mylaswarcoapp.About;
import com.example.mylaswarcoapp.Complaint;
import com.example.mylaswarcoapp.Contact;
import com.example.mylaswarcoapp.Dashboard;
import com.example.mylaswarcoapp.Faqs;
import com.example.mylaswarcoapp.Guideline;
import com.example.mylaswarcoapp.Permit;
import com.example.mylaswarcoapp.R;
import com.example.mylaswarcoapp.Service;
import com.example.mylaswarcoapp.Stakeholders;
import com.example.mylaswarcoapp.TestingActivity;
import com.example.mylaswarcoapp.services.NavigationService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView = null;
    ProgressDialog progressDialog = null;

    Intent intent = null;

    protected NavigationService navigationService = null;


    public void initModule(){
        progressDialog = new ProgressDialog(this);
    }

    public void initNavDrawer(NavigationView.OnNavigationItemSelectedListener context){
        DrawerLayout drawerLayout;
        Toolbar toolbar;
        NavigationView navigationView;

        //Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);

        //Toolbar
        setSupportActionBar(toolbar);


        //Navigation Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.naigation_drawer_open, R.string.naigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Clickable Menu
        navigationView.setNavigationItemSelectedListener(context);

        initModule();

    }

    public void initNavigation(){
        bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                return navSelected(item);
            }

        });
    }

    public void loadAllNavigations(){

        navigationService = new NavigationService();


        navigationService.addNavigation(R.id.about_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(About.class);
            }
        });


        navigationService.addNavigation(R.id.service_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {

                loadActivity(Service.class);

            }
        });


        navigationService.addNavigation(R.id.permit_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Permit.class);
            }
        });


        navigationService.addNavigation(R.id.guideline_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Guideline.class);
            }
        });


        navigationService.addNavigation(R.id.stakeholders_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Stakeholders.class);
            }
        });


        navigationService.addNavigation(R.id.testing_card, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(TestingActivity.class);
            }
        });

        //navigation item selected.

        navigationService.addNavigation(R.id.nav_about, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(About.class);
            }
        });


        navigationService.addNavigation(R.id.nav_service, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Service.class);
            }
        });


        navigationService.addNavigation(R.id.nav_permit, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Permit.class);
            }
        });


        navigationService.addNavigation(R.id.nav_guild, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Guideline.class);
            }
        });


        navigationService.addNavigation(R.id.nav_stakeholders, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Stakeholders.class);
            }
        });



        navigationService.addNavigation(R.id.nav_testing, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(TestingActivity.class);
            }
        });


        navigationService.addNavigation(R.id.nav_home, new NavigationService.NavigationCallback() {
            @Override
            public void callback() {
                loadActivity(Dashboard.class);
            }
        });



    }

    public void selectItem(int item){
        bottomNavigationView.setSelectedItemId(item);
    }



    public boolean navSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId()) {
            case R.id.Bottom_Faqs:

                String faqUrl = "https://laswarco.lagosstate.gov.ng/faq/";
                openBrowser(faqUrl);

//
//                startActivity(new Intent(getApplicationContext(), Faqs.class));
//                overridePendingTransition(0, 0);

                return true;

            case R.id.Bottom_Dashboard:
                startActivity(new Intent(getApplicationContext(),
                        Dashboard.class));
                overridePendingTransition(0, 0);
                return true;

            case R.id.Bottom_Complaint:
                startActivity(new Intent(getApplicationContext(),
                        Complaint.class));
               overridePendingTransition(0, 0);

                //loadActivity(Complaint.class);

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



    public void loadStart_(){
        progressDialog.setTitle("Sending ...");
        progressDialog.show();
    }

    public void loadStop_(){
        progressDialog.hide();
    }

    public void showMessage(String message){
        AlertDialog.Builder alt = new AlertDialog.Builder(this);
        alt.setMessage(message);
        alt.setTitle("Message");
        alt.show();
    }


    public String getInput(int res){
        return  ((EditText)findViewById(res)).getText().toString();
    }

    public void clearInput(int res){
        ((EditText) findViewById(res)).setText("");
    }

    public void loadActivity(Class<?> cls){

        intent = new Intent(this, cls);
        startActivity(intent);

    }


    public void openBrowser(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }


}
