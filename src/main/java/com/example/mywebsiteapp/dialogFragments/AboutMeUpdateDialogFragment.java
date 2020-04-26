package com.example.mywebsiteapp.dialogFragments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.fragments.AboutMeRecycleViewFragment;
import com.example.mywebsiteapp.services.AboutMeService;
import com.example.mywebsiteapp.services.UrlsStrings;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class AboutMeUpdateDialogFragment extends DialogFragment {
    final String aboutMeFragmentTag = "aboutme";
    public AboutMeUpdateDialogFragment aboutMeUpdateDialogFragment = this;
    private EditText section ;
    private EditText details;
    private EditText comment;
    private Context context = getContext();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Server request with data
        View view = inflater.inflate(R.layout.about_me_update_dialog_fragment , container, false);
        section = view.findViewById(R.id.about_me_section);
        details = view.findViewById(R.id.about_me_details);
        comment = view.findViewById(R.id.about_me_comment);
        final Button closeAboutMe = (Button)view.findViewById(R.id.about_me_fragment_close_btn);
        final Button createAboutMe = (Button)view.findViewById(R.id.about_me_update_btn);
        createAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "fire post request");
                Log.v("TEST", section.getText().toString() + " , " +
                                        details.getText().toString() + " , " +
                                        comment.getText().toString() );

                // {"id":null,"section":"education","details":"flight","cooment":"testComment1"}
                JSONObject obj = new JSONObject();
                try {
                    obj.put("id",null);
                    obj.put("section", section.getText().toString());
                    obj.put("details", details.getText().toString());
                    obj.put("cooment", comment.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, UrlsStrings.baseUrlSetAboutMe, obj,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.v("TEST" , response.toString());
                                Toast.makeText(getContext() , "About me created" , Toast.LENGTH_SHORT ).show();
                                clearCreate();
                                AboutMeService.getInstance().getAboutMeServer(getContext(), aboutMeUpdateDialogFragment);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("TEST" , error.toString());
                                Toast.makeText(getContext() , "Create about me failed" , Toast.LENGTH_SHORT ).show();
                                clearCreate();
                                AboutMeService.getInstance().getAboutMeServer(getContext(), aboutMeUpdateDialogFragment);
                            }
                        }
                )
                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("Content-Type" , "application/json");
                        params.put("Authorization" , MainActivity.key + MainActivity.jwt);
                        return  params;
                    }
                };

                Volley.newRequestQueue(getContext()).add(jsonObjectRequest);


            }
        });



        closeAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AboutMeUpdateDialogFragment.this.dismiss();
                AboutMeService.aboutMeModelsServer.clear();
            }
        });


        FragmentManager fm = getChildFragmentManager();
        AboutMeRecycleViewFragment aboutMeFragment = (AboutMeRecycleViewFragment)fm.findFragmentById(R.id.about_me_fragment);
        if (aboutMeFragment==null){
            aboutMeFragment = new AboutMeRecycleViewFragment();
            fm.beginTransaction().add(R.id.about_me_fragment , aboutMeFragment , aboutMeFragmentTag).addToBackStack(aboutMeFragmentTag).commit();

        }

        AboutMeService.getInstance().getAboutMeServer(getContext(), this);

        return view;
    }

    public void onDataReceived(){
        Log.v("TEST" , "data has come");
        AboutMeRecycleViewFragment aboutMe = (AboutMeRecycleViewFragment)getChildFragmentManager().findFragmentByTag(aboutMeFragmentTag);
        getChildFragmentManager().beginTransaction()
                .detach(aboutMe)
                .attach(aboutMe)
                .commit();
    }

    private void clearCreate(){
        section.setText("");
        details.setText("");
        comment.setText("");

    }





}
