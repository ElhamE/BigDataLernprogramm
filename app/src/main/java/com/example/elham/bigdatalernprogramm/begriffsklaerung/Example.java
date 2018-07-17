package com.example.elham.bigdatalernprogramm.begriffsklaerung;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elham.bigdatalernprogramm.R;

public class Example extends Fragment {

    private TextView mText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.begriffsklaerung_menu, container, false);
        mText = (TextView) rootView.findViewById(R.id.text_view_id);
        mText.setTextColor(Color.RED);
        mText.setText("Hallo Welt!");
        return rootView;
    }
}
