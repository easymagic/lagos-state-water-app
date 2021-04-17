package com.example.mylaswarcoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

     CardView about, service, permit,  guideline, stakeholders, complaint ;
            private static int SPLASH_TIME_OUT = 5000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

             //Defining delay handler
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(intent);
                    finish();
                }

            }, SPLASH_TIME_OUT );


            about.setOnClickListener(this);
            service.setOnClickListener(this);
            permit.setOnClickListener(this);
            guideline.setOnClickListener(this);
            stakeholders.setOnClickListener(this);
            complaint.setOnClickListener(this);

            // Defining CardViews

            about=(CardView) findViewById(R.id.about_card);
            service=(CardView)findViewById(R.id.service_card);
            permit= (CardView)findViewById(R.id.permit_card);
            guideline=(CardView)findViewById(R.id.guideline_card);
            stakeholders=(CardView)findViewById(R.id.stakeholders_card);
            complaint=(CardView)findViewById(R.id.complaint_card);

            //Add listener to the card




        }


    @Override
    public void onClick(View v) {
            Intent i;
            switch (v.getId()){
                case R.id.about_card: i=new Intent(this,About.class); startActivity(i); break;
                case R.id.service_card: i=new Intent(this,Service.class); startActivity(i);break;
                case R.id.permit_card: i=new Intent(this,Permit.class); startActivity(i);break;
                case R.id.guideline_card: i=new Intent(this,Guideline.class); startActivity(i);break;
                case R.id.stakeholders_card: i=new Intent(this,Stakeholders.class); startActivity(i);break;
                case R.id.complaint_card: i=new Intent(this,Complaint.class); startActivity(i);break;
                default:break;
            }
    }
}