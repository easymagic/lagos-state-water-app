package com.example.mylaswarcoapp.services;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiService {

    private static Context context = null;

    public static void initContext(Context ctx){
        context = ctx;
    }


    public static void post(String url,PayloadInterface payloadInterface){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        PayLoadData payLoadData = payloadInterface.getPayload(new PayLoadData());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, payLoadData.getPayload(), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                payloadInterface.completed(response);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

              payloadInterface.error(error.getMessage());

            }
        });

        

    }

    public static void get(String url){

    }




    static class PayLoadData{

        JSONObject jsonObject = null;

        public PayLoadData(){
            jsonObject = new JSONObject();
        }


        public void set(String key,String value){
            try {
                jsonObject.put(key,value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public JSONObject getPayload(){
            return jsonObject;
        }


    }


    interface PayloadInterface{

        PayLoadData getPayload(PayLoadData payLoadData);
        void completed(JSONObject jsonObject);
        void error(String errorMessage);

    }


}
