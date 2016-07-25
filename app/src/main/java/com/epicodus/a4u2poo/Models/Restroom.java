package com.epicodus.a4u2poo.Models;

import java.util.Date;

/**
 * Created by Guest on 7/25/16.
 */
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
    private Date mCreated;
    private Date mUpdated;
    private int mDownvotes;
    private int mUpvotes;

    public Restroom(int id, String name, String street, String city, String state, String country, boolean accessible, boolean unisex, String directions, String comments, double latitude, double longitude, Date created, Date updated, int downvotes, int upvotes) {
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
        mCreated = created;
        mUpdated = updated;
        mDownvotes = downvotes;
        mUpvotes = upvotes;
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

    public Date getCreated() {
        return mCreated;
    }

    public void setCreated(Date created) {
        mCreated = created;
    }

    public Date getUpdated() {
        return mUpdated;
    }

    public void setUpdated(Date updated) {
        mUpdated = updated;
    }

    public int getDownvotes() {
        return mDownvotes;
    }

    public void setDownvotes(int downvotes) {
        mDownvotes = downvotes;
    }

    public int getUpvotes() {
        return mUpvotes;
    }

    public void setUpvotes(int upvotes) {
        mUpvotes = upvotes;
    }
// TODO: 7/25/16 Add distance and bearing or compute nav metrics locally?
    
}
