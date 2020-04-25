package com.example.mywebsiteapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {
    final public static String key="key ";
    public static String jwt ;
    final int passUserLength = 3;
    final String LOCAL_URL_BASE = "http://10.0.2.2:8181";
    final String GET_ALL = "/getallvisitors";
    final String TEST_LINK = "/test";
    final String AUTHENTICATE = "/authenticate";
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_circular);
        final TextInputEditText usernameInput = findViewById(R.id.userNameInput);
        final TextInputEditText passwordInput = findViewById(R.id.passwordInput);
        Button logInBtn  = findViewById(R.id.buttonLogIn);
        progressBar.setVisibility(View.INVISIBLE);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if(username.length()<passUserLength || password.length()<passUserLength ){
                Log.v("TEST" , "Password or username not valid");
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext() , "user name or password can not be empty" , Toast.LENGTH_SHORT ).show();
            }
                else {
                    Log.v("TEST", "user details passed");
                    login(username,password);
                }
            }
        });
    }

        private void login(String username, String password) {
            String autchenaticateUrl = LOCAL_URL_BASE + AUTHENTICATE;
            JSONObject jsonBody = new JSONObject();
            try {
                jsonBody.put("username", username);
                jsonBody.put("password", password);
                final String loginBody = jsonBody.toString();
                final StringRequest logInRequest = new StringRequest(Request.Method.POST, autchenaticateUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jwtJSON = new JSONObject(response);
                            jwt = jwtJSON.getString("jwt");
                            Log.v("TEST" , "we got pure jwt: " + jwt);
                            Intent homeScreen = new Intent(MainActivity.this , HomeActivity.class);
                            progressBar.setVisibility(View.INVISIBLE);
                            startActivity(homeScreen);
                            // Starting new activity from here :)

                        }catch (JSONException e){
                            Log.v("TEST" , "JWT json parse failed");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST", "FAILED " + error.toString());
                        Toast.makeText(getApplicationContext(),"Log-In failed. Wrong user details, try again", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
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




    }

