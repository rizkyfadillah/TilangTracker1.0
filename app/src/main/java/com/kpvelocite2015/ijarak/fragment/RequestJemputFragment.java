package com.kpvelocite2015.ijarak.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpvelocite2015.ijarak.R;

public class RequestJemputFragment extends Fragment {

    View rootview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("OnCreateView");
        rootview = inflater.inflate(R.layout.fragment_request_jemput_cucian, container, false);

        return rootview;
    }


}