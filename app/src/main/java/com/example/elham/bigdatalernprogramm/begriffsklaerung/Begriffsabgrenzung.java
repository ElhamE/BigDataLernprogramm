package com.example.elham.bigdatalernprogramm.begriffsklaerung;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.elham.bigdatalernprogramm.R;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.bumptech.glide.Glide;

public class Begriffsabgrenzung extends Fragment {

    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.begriffsabgrenzung, container, false);
        return rootView;
    }

    @Override
    public void onStart(){
        //load picture
        super.onStart();
        mImageView = getActivity().findViewById(R.id.photo_view);
        mAttacher = new PhotoViewAttacher(mImageView);
        Glide.with(this)
                .load(R.drawable.begriffsabgrenzung)
                .fitCenter()
                .into(mImageView);
    }
}
