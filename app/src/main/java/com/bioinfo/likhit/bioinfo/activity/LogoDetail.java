/*
Created By: Likhit C U
Date:02-08-2018
Activity class for showing user details
 */

package com.bioinfo.likhit.bioinfo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bioinfo.likhit.bioinfo.R;

public class LogoDetail extends AppCompatActivity {

    //TextView Variables
    private TextView username,password,id,name,age,city,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo_detail);

        //fetching data frpom intent ibto bundle
        Bundle userInfo=getIntent().getExtras();

        if(userInfo==null){
            return;
        }

        username=(TextView)findViewById(R.id.userNameAnswer);
        password=(TextView)findViewById(R.id.passwordAnswer);
        id=(TextView)findViewById(R.id.idAnswer);
        name=(TextView)findViewById(R.id.nameAnswer);
        age=(TextView)findViewById(R.id.ageAnswer);
        city=(TextView)findViewById(R.id.cityAnswer);
        company=(TextView)findViewById(R.id.companyAnswer);

        //setting UI Views using received values from intent
        username.setText(userInfo.getString("username"));
        password.setText(userInfo.getString("password"));
        id.setText(userInfo.getString("id"));
        name.setText(userInfo.getString("name"));
        age.setText(userInfo.getString("age"));
        city.setText(userInfo.getString("city"));
        company.setText(userInfo.getString("company"));
    }
}
