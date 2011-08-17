package com.androidApp.ordering.service;

import com.androidApp.ordering.model.User;
import com.androidApp.ordering.util.MenuConfig;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginService {
    private SharedPreferences prefs = null; 
    private Context ctx;
    
    public LoginService(Context c){
        this.ctx=c;
        this.prefs=c.getSharedPreferences(MenuConfig.PREF_USER_INFO, Context.MODE_PRIVATE);
    }
    
    public static LoginService loginService;
    
    public static LoginService getInstance(Context c){
        if(loginService==null)
            return new LoginService(c);
         return loginService;   
    }
    
    public User getUser(){
        return  null;
    }

    public void updateUser(){
        
    }
}
