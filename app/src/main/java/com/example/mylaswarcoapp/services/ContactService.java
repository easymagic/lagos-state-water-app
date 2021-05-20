package com.example.mylaswarcoapp.services;

import org.json.JSONObject;

public class ContactService {


    static void getToken(ApiService.PayloadInterface payloadInterface){
        ApiService.get("http://espconcept.com/lagos-state-water-corp/public/api/token/create", payloadInterface);
    }

    public static void send(ApiService.PayloadInterface payloadInterface){

        getToken(new ApiService.PayloadInterface() {
            @Override
            public ApiService.PayLoadData getPayload(ApiService.PayLoadData payLoadData) {
                return payloadInterface.getPayload(payLoadData);
            }

            @Override
            public void completed(JSONObject jsonObject) {

                String token = jsonObject.optJSONObject("token").optString("plainTextToken");
                payloadInterface.setBearerToken(token);
                sendData(payloadInterface);

            }

            @Override
            public void error(String errorMessage) {

                payloadInterface.error(errorMessage);

            }

            @Override
            public void loadStart() {

                payloadInterface.loadStart();

            }

            @Override
            public void loadStop() {

                payloadInterface.loadStop();

            }

            @Override
            public String getBearerToken() {
                return payloadInterface.getBearerToken();
            }

            @Override
            public void setBearerToken(String token) {

            }
        });


    }

    public static void sendData(ApiService.PayloadInterface payloadInterface){
        ApiService.post("http://espconcept.com/lagos-state-water-corp/public/api/feedback/create",payloadInterface);
    }



}
