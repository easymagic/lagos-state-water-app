package com.example.mylaswarcoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mylaswarcoapp.services.ApiService;
import com.example.mylaswarcoapp.services.ComplaintService;

import org.json.JSONObject;

public class Complaint extends AppCompatActivity {

    ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        init();
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

    void init(){

        progressDialog = new ProgressDialog(this);

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
                    public void error(String errorMessage) {

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