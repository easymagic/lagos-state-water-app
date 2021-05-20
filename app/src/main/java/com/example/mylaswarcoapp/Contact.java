package com.example.mylaswarcoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mylaswarcoapp.base.BaseActivity;
import com.example.mylaswarcoapp.services.ApiService;
import com.example.mylaswarcoapp.services.ComplaintService;
import com.example.mylaswarcoapp.services.ContactService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;

public class Contact extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        initNavigation();


        init();

//        selectItem(R.id.Bottom_Contact);

    }


    void init(){

        initModule();


        ApiService.initContext(this);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] token = {""};

                ContactService.send(new ApiService.PayloadInterface() {
                    @Override
                    public ApiService.PayLoadData getPayload(ApiService.PayLoadData payLoadData) {


                        /**
                         *
                         * "name":"akl...",
                         *     "email":"akl@domain.com",
                         *     "phone_number":"0900008",
                         *     "comment":"test comment ...",
                         *     "type":"type1"
                         */

                        payLoadData.set("name",getInput(R.id.name));
                        payLoadData.set("email",getInput(R.id.email));
                        payLoadData.set("phone_number",getInput(R.id.phone_number));
                        payLoadData.set("address",getInput(R.id.address));
                        payLoadData.set("comment",getInput(R.id.comment));
                        payLoadData.set("type","feedback");


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

}