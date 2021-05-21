package com.example.mylaswarcoapp.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.mylaswarcoapp.About;
import com.example.mylaswarcoapp.Complaint;
import com.example.mylaswarcoapp.Contact;
import com.example.mylaswarcoapp.Dashboard;
import com.example.mylaswarcoapp.Faqs;
import com.example.mylaswarcoapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView = null;
    ProgressDialog progressDialog = null;

    Intent intent = null;

    public void initModule(){
        progressDialog = new ProgressDialog(this);
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

    public void selectItem(int item){
        bottomNavigationView.setSelectedItemId(item);
    }



    public boolean navSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId()) {
            case R.id.Bottom_Faqs:

                String whistleBlowingUrl = "https://laswarco.lagosstate.gov.ng/whistle-blowing/";
                openBrowser(whistleBlowingUrl);

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

                loadActivity(Complaint.class);

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
