package com.example.mylaswarcoapp.services;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiService {

    private static Context context = null;

    public static void initContext(Context ctx){
        context = ctx;
    }


    public static void post(String url,PayloadInterface payloadInterface){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        PayLoadData payLoadData = payloadInterface.getPayload(new PayLoadData());
        payloadInterface.loadStart();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, payLoadData.getPayload(), new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                payloadInterface.completed(response);
                payloadInterface.loadStop();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

              payloadInterface.error(error.getMessage());
              payloadInterface.loadStop();

            }
        }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

//                'Accept: application/json',
//                        'Authorization: Bearer 1|JqHGjNZcq1DKhotm5TFtIMN9esURoxFcxi1n9Jzm',
//                        'Content-Type: application/json'

                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept","application/json");
                params.put("Content-Type","application/json");
                if (payloadInterface.getBearerToken() != null){
                    params.put("Authorization","Bearer " + payloadInterface.getBearerToken());
                }

//                return super.getHeaders();

                return params;
            }




        };

        requestQueue.add(jsonObjectRequest);

    }

    public static void get(String url,PayloadInterface payloadInterface){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        payloadInterface.loadStart();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    payloadInterface.completed(new JSONObject(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                payloadInterface.loadStop();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                payloadInterface.error(error.getMessage());
                payloadInterface.loadStop();

            }
        }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };


        requestQueue.add(stringRequest);


    }




    public static class PayLoadData{

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


   public interface PayloadInterface{

        PayLoadData getPayload(PayLoadData payLoadData);
        void completed(JSONObject jsonObject);
//        void completed(String response);
        void error(String errorMessage);
        void loadStart();
        void loadStop();
        String getBearerToken();
        void setBearerToken(String token);

    }


}
