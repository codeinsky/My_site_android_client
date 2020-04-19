package com.example.mywebsiteapp.dialogFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.fragments.VisitorRecycleViewFragment;
import com.example.mywebsiteapp.services.VisitorService;

public class VisitorReportDialogFragment extends DialogFragment {
    private final String visitorFragmentTag = "visitorTag";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.visitor_dialog_fragment, container , false);
        VisitorService.getInstance().getVisitorsServer(view.getContext() , this);
        FragmentManager fm = getChildFragmentManager();

        VisitorRecycleViewFragment visitorRecycleViewFragment = (VisitorRecycleViewFragment)fm.findFragmentById(R.id.visitor_report_fragment);
        if (visitorRecycleViewFragment==null){
            visitorRecycleViewFragment = new VisitorRecycleViewFragment();
            fm.beginTransaction().add(R.id.visitor_report_fragment , visitorRecycleViewFragment , visitorFragmentTag).commit();
        }

        Button closeVisitorDialog = (Button)view.findViewById(R.id.visitor_dialog_close_btn);
        closeVisitorDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VisitorReportDialogFragment.this.dismiss();
                VisitorService.visitorsFromServer.clear();
            }
        });




       return view;
    }

    public void onDataReceived(){
        Log.v("TEST" , "data has come");
        VisitorRecycleViewFragment fragment = (VisitorRecycleViewFragment) getChildFragmentManager().findFragmentByTag(visitorFragmentTag);
        getChildFragmentManager().beginTransaction()
                .detach(fragment)
                .attach(fragment)
                .commit();
    }


}
