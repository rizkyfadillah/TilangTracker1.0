package com.kpvelocite2015.ijarak.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpvelocite2015.ijarak.R;
import com.kpvelocite2015.ijarak.SessionManager;

import java.util.HashMap;

public class ReportedFragment extends Fragment {

    private View rootview;

    SessionManager sessionManager;

    String idUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("OnCreateView");

        rootview = inflater.inflate(R.layout.fragment_reported, container, false);

        sessionManager = new SessionManager(rootview.getContext());
        HashMap<String, String> user = sessionManager.getUserDetails();

        idUser = user.get("id");

        return rootview;
    }

}
