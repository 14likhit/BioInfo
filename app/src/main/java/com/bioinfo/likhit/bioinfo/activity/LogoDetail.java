package com.bioinfo.likhit.bioinfo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.bioinfo.likhit.bioinfo.R;

public class LogoDetail extends AppCompatActivity {

    private TextView username,password,id,name,age,city,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo_detail);

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

        username.setText(userInfo.getString("username"));
        password.setText(userInfo.getString("password"));
        id.setText(userInfo.getString("id"));
        name.setText(userInfo.getString("name"));
        age.setText(userInfo.getString("age"));
        city.setText(userInfo.getString("city"));
        company.setText(userInfo.getString("company"));
    }
}
