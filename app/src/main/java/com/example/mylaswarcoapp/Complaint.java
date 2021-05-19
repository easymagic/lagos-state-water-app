package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.mylaswarcoapp.services.ApiService;
import com.example.mylaswarcoapp.services.ComplaintService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

public class Complaint extends AppCompatActivity {

    ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        init();
        initNavigation();
    }

    String getInput(int res){
        return  ((EditText)findViewById(res)).getText().toString();
    }


    void loadStart_(){
        progressDialog.setTitle("Sending ...");
        progressDialog.show();
    }

    void loadStop_(){
        progressDialog.hide();
    }

    void showMessage(String message){
        AlertDialog.Builder alt = new AlertDialog.Builder(this);
        alt.setMessage(message);
        alt.setTitle("Message");
        alt.show();
    }

    void initNavigation(){
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                return navSelected(item);
            }

        });
    }

    void init(){

        progressDialog = new ProgressDialog(this);

        ApiService.initContext(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] token = {""};

                ComplaintService.send(new ApiService.PayloadInterface() {
                    @Override
                    public ApiService.PayLoadData getPayload(ApiService.PayLoadData payLoadData) {

                        payLoadData.set("name",getInput(R.id.name));
                        payLoadData.set("email",getInput(R.id.email));
                        payLoadData.set("phone_number",getInput(R.id.phone_number));
                        payLoadData.set("address",getInput(R.id.address));
                        payLoadData.set("comment",getInput(R.id.comment));


                        return payLoadData;

                    }

                    @Override
                    public void completed(JSONObject jsonObject) {

                        showMessage(jsonObject.optString("message"));

                    }

                    @Override
                    public void error(String errorMessage){

                        showMessage(errorMessage);

                    }

                    @Override
                    public void loadStart() {

                        loadStart_();

                    }

                    @Override
                    public void loadStop() {

                        loadStop_();

                    }

                    @Override
                    public String getBearerToken() {
                        return token[0];
                    }

                    @Override
                    public void setBearerToken(String token_) {
                       token[0] = token_;
                    }
                });



            }
        });

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

}