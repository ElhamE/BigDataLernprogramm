package com.example.elham.bigdatalernprogramm.praxis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.elham.bigdatalernprogramm.R;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class Herausforderungen extends Fragment {

    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.herausforderungen, container, false);
        return rootView;
    }

    @Override
    public void onStart(){
        //load picture
        super.onStart();
        mImageView = getActivity().findViewById(R.id.photo_view);
        mAttacher = new PhotoViewAttacher(mImageView);
        Glide.with(this)
                .load(R.drawable.lebenszyklus)
                .fitCenter()
                .into(mImageView);
    }
}
