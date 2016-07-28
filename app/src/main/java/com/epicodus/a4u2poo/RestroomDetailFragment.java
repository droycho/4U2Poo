package com.epicodus.a4u2poo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.a4u2poo.Models.Restroom;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RestroomDetailFragment extends Fragment {

    @Bind(R.id.pooImageView) ImageView mPooImageView;
    @Bind(R.id.tName) TextView mName;
    @Bind(R.id.tStreet) TextView mStreet;
    @Bind(R.id.tRating) TextView mRating;
    @Bind(R.id.tComments) TextView mComments;
    @Bind(R.id.tADA) TextView mADA;
    @Bind(R.id.tGender) TextView mGender;
    @Bind(R.id.tThumbsUp) TextView mThumbsUp;
    @Bind(R.id.tThumbsDown) TextView mThumbsDown;
    @Bind(R.id.tGenderView) TextView mGenderView;

    private Restroom mRestroom;

    public static RestroomDetailFragment newInstance(Restroom restroom) {
        RestroomDetailFragment RestroomDetailFragment = new RestroomDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("restroom", Parcels.wrap(restroom));
        RestroomDetailFragment.setArguments(args);
        return RestroomDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRestroom = Parcels.unwrap(getArguments().getParcelable("restroom"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restroom_detail, container, false);
        ButterKnife.bind(this, view);

        mName.setText(mRestroom.getName());
        mStreet.setText(mRestroom.getStreet());
        mComments.setText(mRestroom.getComments());
        if(mRestroom.isAccessible() == true){
        mADA.setText("Yes");
        } else {
            mADA.setText("No");
        }
        if(mRestroom.isUnisex() == true){
            mGender.setText("Yes");
        } else {
            mGender.setText("No");
        }

        String upVote = Integer.toString(mRestroom.getUpvotes());
        mThumbsUp.setText(upVote);

        String downVote = Integer.toString(mRestroom.getDownvotes());
        mThumbsDown.setText(downVote);

        mRating.setText("U+1F4A9");

        return view;
    }
}


