package com.example.mylaswarcoapp.services;

import java.util.HashMap;

public class NavigationService {

    private HashMap<Integer,NavigationCallback> hashMap = null;

    public NavigationService(){
        init();
    }

    public void init(){
        if (hashMap == null)
          hashMap = new HashMap<>();
    }

//    public static void reset(){
//        hashMap = new HashMap<>();
//    }

    public void addNavigation(int nav,NavigationCallback navigationCallback){
//        init();
        hashMap.put(nav,navigationCallback);
    }


    public void triggerNavigation(int nav){
        hashMap.get(nav).callback();
    }



    public interface NavigationCallback{
        void callback();
    }


}


