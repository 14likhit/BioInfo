package com.bioinfo.likhit.bioinfo.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bioinfo.likhit.bioinfo.R;
import com.bioinfo.likhit.bioinfo.helper.MySingleton;
import com.bioinfo.likhit.bioinfo.model.Details;

import org.json.JSONException;
import org.json.JSONObject;

public class LogoSplash extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private CheckBox showPassword;
    private String user,pass;
    //private Details userInfo;
    private String usernamedetail,passworddetail,id,name,age,city,company;
    private String json_url_main="http://www.beta.colourdrive.in/apk/user_detail.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo_splash);

        userName=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
        showPassword=(CheckBox)findViewById(R.id.showPassword);
    }


    //Handler for showing Password
    void showPassword(View v){
        if(showPassword.isChecked()){
            password.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        if(!(showPassword.isChecked())){
            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    //Login on click Method
    void logIn(View v){

        user=userName.getText().toString();
        pass=password.getText().toString();
        if(user.equalsIgnoreCase("") || pass.equalsIgnoreCase("")){
            Toast.makeText(this,"Please fill the required Credentials",Toast.LENGTH_LONG).show();
        }
        else{
//            boolean check= getUserInfo();
            getUserInfo();
//            Intent intent = new Intent(this,LogoDetail.class);
//            intent.putExtra("username",userInfo.getUserName());
//            intent.putExtra("password",userInfo.getPassword());
//            intent.putExtra("id",userInfo.getId());
//            intent.putExtra("name",userInfo.getName());
//            intent.putExtra("age",userInfo.getAge());
//            intent.putExtra("city",userInfo.getName());
//            intent.putExtra("contact",userInfo.getContact());
//            if(check){
//                Intent intent = new Intent(this,LogoDetail.class);
//                intent.putExtra("username",usernamedetail);
//                intent.putExtra("password",passworddetail);
//                intent.putExtra("id",id);
//                intent.putExtra("name",name);
//                intent.putExtra("age",age);
//                intent.putExtra("city",city);
//                intent.putExtra("company",company);
//                this.startActivity(intent);
//            }

        }

    }

    private void getUserInfo(){
        String json_url=json_url_main+"username="+user+"&password="+pass;
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Login");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, json_url, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Intent intent = new Intent(LogoSplash.this,LogoDetail.class);
                            intent.putExtra("username",response.getString("username"));
                            intent.putExtra("password",response.getString("password"));
                            intent.putExtra("id",response.getString("id"));
                            intent.putExtra("name",response.getString("name"));
                            intent.putExtra("age",response.getString("age"));
                            intent.putExtra("city",response.getString("age"));
                            intent.putExtra("company",response.getString("company"));
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Unable to login. Please check credentials.",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        }
        );
        //MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
        //password.setText("Done");

    }
}
