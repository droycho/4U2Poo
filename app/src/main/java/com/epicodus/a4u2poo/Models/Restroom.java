package com.epicodus.a4u2poo.Models;

import android.util.Log;

import com.epicodus.a4u2poo.Constants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcel;


@Parcel
public class Restroom {
    private int mId;
    private String mName;
    private String mStreet;
    private String mCity;
    private String mState;
    private String mCountry;
    private boolean mAccessible;
    private boolean mUnisex;
    private String mDirections;
    private String mComments;
    private double mLatitude;
    private double mLongitude;
//    private Date mCreated;
//    private Date mUpdated;
    private int mRefugeDownvotes;
    private int mRefugeUpvotes;
    private int mFirebaseDownvotes;
    private int mFirebaseUpvotes;

    public Restroom(int id, String name, String street, String city, String state, String country, boolean accessible, boolean unisex, String directions, String comments, double latitude, double longitude, int refugeDownvotes, int refugeUpvotes) {
        mId = id;
        mName = name;
        mStreet = street;
        mCity = city;
        mState = state;
        mCountry = country;
        mAccessible = accessible;
        mUnisex = unisex;
        mDirections = directions;
        mComments = comments;
        mLatitude = latitude;
        mLongitude = longitude;
//        mCreated = created;
//        mUpdated = updated;
        mRefugeDownvotes = refugeDownvotes;
        mRefugeUpvotes = refugeUpvotes;
    }

    public Restroom() {

    }

    public Restroom(String name) {
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String street) {
        mStreet = street;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public boolean isAccessible() {
        return mAccessible;
    }

    public void setAccessible(boolean accessible) {
        mAccessible = accessible;
    }

    public boolean isUnisex() {
        return mUnisex;
    }

    public void setUnisex(boolean unisex) {
        mUnisex = unisex;
    }

    public String getDirections() {
        return mDirections;
    }

    public void setDirections(String directions) {
        mDirections = directions;
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String comments) {
        mComments = comments;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

//    public Date getCreated() {
//        return mCreated;
//    }
//
//    public void setCreated(Date created) {
//        mCreated = created;
//    }
//
//    public Date getUpdated() {
//        return mUpdated;
//    }
//
//    public void setUpdated(Date updated) {
//        mUpdated = updated;
//    }

    public int getDownvotes() {
        return mRefugeDownvotes;
    }

    public void setRefugeDownvotes(int downvotes) {
        mRefugeDownvotes = downvotes;
    }

    public int getRefugeUpvotes() {
        return mRefugeUpvotes;
    }

    public void setUpvotes(int upvotes) {
        mRefugeUpvotes = upvotes;
    }
// TODO: 7/25/16 Add distance and bearing or compute nav metrics locally?

    public int getFirebaseDownvotes() {
        return mFirebaseDownvotes;
    }

    public void setFirebaseDownvotes(int mFirebaseDownvotes) {
        this.mFirebaseDownvotes = mFirebaseDownvotes;
    }

    public int getFirebaseUpvotes() {
        return mFirebaseUpvotes;
    }

    public void setFirebaseUpvotes(int mFirebaseUpvotes) {
        this.mFirebaseUpvotes = mFirebaseUpvotes;
    }

    public void upVote() {
        this.setFirebaseUpvotes(getFirebaseUpvotes() + 1);
    }

    public void downVote() {
        this.setFirebaseDownvotes(getFirebaseDownvotes() + 1);
    }

    public void addToFirebase() {
        final Restroom restroom = this;
        final DatabaseReference restroomRef = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_RESTROOMS)
                .child(String.valueOf(mId));
        restroomRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    restroomRef.setValue(restroom);
                    Log.d("Restroom.java", "Added to Firebase: " + restroom.getName());
                } else {
                    Log.d("Restroom.java", "Not Added to Firebase: " + restroom.getName());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Restroom.java", databaseError.toException());
            }
        });
    }
}
