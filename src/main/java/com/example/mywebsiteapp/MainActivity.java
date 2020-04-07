package com.example.mywebsiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {

    final String LOCAL_URL_BASE = "http://10.0.2.2:8181";
    final String GET_ALL = "/getallvisitors";
    final String TEST_LINK = "/test";
    final String AUTHENTICATE = "/authenticate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputEditText inputEditText = findViewById(R.id.userNameInput);
        TextInputEditText passWordInput = findViewById(R.id.passwordInput);
        Button logInBtn  = findViewById(R.id.buttonLogIn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "button clicked");
            }
        });
    }

        public void login() {
            String autchenaticateUrl = LOCAL_URL_BASE + AUTHENTICATE;
            JSONObject jsonBody = new JSONObject();
            try {
                jsonBody.put("username", "foo");
                jsonBody.put("password", "foo");
                final String loginBody = jsonBody.toString();
                final StringRequest logInRequest = new StringRequest(Request.Method.POST, autchenaticateUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("TEST", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST", error.toString());
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return loginBody == null ? null : loginBody.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", loginBody, "utf-8");
                            return null;
                        }
                    }
                };
                Volley.newRequestQueue(this).add(logInRequest);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        public Boolean userPassValidation(String username, String password){
            boolean usernamePassed=false;
            boolean passwordPassed=false;
            if (username==null || username ==""){
                usernamePassed = false;
                
            }

            if (password==null || password=="") {
                passwordPassed=false;
            }
            return (usernamePassed && passwordPassed);
        }

    }

