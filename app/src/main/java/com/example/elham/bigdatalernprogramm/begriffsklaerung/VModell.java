package com.example.elham.bigdatalernprogramm.begriffsklaerung;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elham.bigdatalernprogramm.R;

public class VModell extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.information_vmodell, container, false);
        return rootView;
    }
}
