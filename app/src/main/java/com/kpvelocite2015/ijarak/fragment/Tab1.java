package com.kpvelocite2015.ijarak.fragment;

/**
 * Created by hallidafykzir on 10/24/2015.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpvelocite2015.ijarak.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);

        return v;
    }
}