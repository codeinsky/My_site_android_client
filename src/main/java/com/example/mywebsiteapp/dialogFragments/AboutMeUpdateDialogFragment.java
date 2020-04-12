package com.example.mywebsiteapp.dialogFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.fragments.AboutMeRecycleViewFragment;

public class AboutMeUpdateDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_me_update_dialog_fragment , container, false);
        final EditText section = view.findViewById(R.id.about_me_section);
        final EditText details = view.findViewById(R.id.about_me_details);
        final EditText comment = view.findViewById(R.id.about_me_comment);
        final Button closeAboutMe = (Button)view.findViewById(R.id.about_me_fragment_close_btn);
        final Button createAboutMe = (Button)view.findViewById(R.id.about_me_update_btn);
        createAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "fire post request");
                Log.v("TEST", section.getText().toString() + " , " +
                                        details.getText().toString() + " , " +
                                        comment.getText().toString() );
            }
        });
        closeAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutMeUpdateDialogFragment.this.dismiss();
            }
        });
        FragmentManager fm = getChildFragmentManager();
        AboutMeRecycleViewFragment aboutMeFragment = (AboutMeRecycleViewFragment)fm.findFragmentById(R.id.about_me_fragment);
        if (aboutMeFragment==null){
            aboutMeFragment = new AboutMeRecycleViewFragment();
            fm.beginTransaction().add(R.id.about_me_fragment , aboutMeFragment).commit();
        }


        return view;
    }


}
