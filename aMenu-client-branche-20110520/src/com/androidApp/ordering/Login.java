package com.androidApp.ordering;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidApp.ordering.model.User;

/**
 * TODO Comment of Login
 * 2011-5-20
 * @author 轩
 *
 */
public class Login extends Activity {
    
    private User user;
    private EditText etUserId,etPassword;
    private ImageButton buLogin;
    private ProgressDialog progressDialog;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.etUserId=(EditText) findViewById(R.id.user_id_editText);
        this.etPassword=(EditText) findViewById(R.id.password_editText);
        this.buLogin=(ImageButton) findViewById(R.id.button_bg);
        this.buLogin.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                user=new User();
                user.setUserId(etUserId.getText().toString());
                user.setUserPassword(etPassword.getText().toString());
//                if(user.getUserId().length()==0 || user.getUserPassword().length()==0){
//                    new AlertDialog.Builder(Login.this).setMessage(getText(R.string.login_notext_alert)).setPositiveButton("Okay", null).show();
//                }else{
                    userLogin();
//                }
                
            }
        });
    }
    
    /**
     * 用户登录
     */
    private void userLogin(){
        progressDialog=ProgressDialog.show(Login.this,getText(R.string.sys_dialog_tips) , getText(R.string.login_message),true);
        new Thread(){
            public void run(){
                Intent main=new Intent(Login.this, Main.class);
                startActivity(main);
                finish();
                progressDialog.dismiss();
            }
        }.start();
        
    }
}