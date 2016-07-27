package com.epicodus.a4u2poo.Services;

import android.util.Log;

import com.epicodus.a4u2poo.Constants;
import com.epicodus.a4u2poo.Models.Restroom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 7/25/16.
 */
public class RefugeService {
    public final String TAG = RefugeService.class.getSimpleName();


    public static void queryRefuge(double latitude, double longitude, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.REFUGE_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Restroom> processResults(Response response) {
        ArrayList<Restroom> restrooms = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONArray refugeJSON = new JSONArray(jsonData);
                for (int i = 0; i < refugeJSON.length(); i++) {
                    JSONObject restroomJSON = refugeJSON.getJSONObject(i);
                    int id = restroomJSON.getInt("id");
                    String name = restroomJSON.getString("name");
                    String street = restroomJSON.getString("street");
                    String city = restroomJSON.getString("city");
                    String state = restroomJSON.getString("state");
                    String country = restroomJSON.getString("country");
                    boolean accessible = restroomJSON.getBoolean("accessible");
                    boolean unisex = restroomJSON.getBoolean("unisex");
                    String directions = restroomJSON.getString("directions");
                    String comments = restroomJSON.getString("comment");
                    double latitude = restroomJSON.getDouble("latitude");
                    double longitude = restroomJSON.getDouble("longitude");
                    String created = restroomJSON.getString("created_at");
                    String updated = restroomJSON.getString("updated_at");
                    int downvotes = restroomJSON.getInt("downvote");
                    int upvotes = restroomJSON.getInt("upvote");
                    Restroom restroom = new Restroom(id, name, street, city, state, country, accessible, unisex, directions, comments, latitude, longitude, created, updated, downvotes, upvotes);
                    restrooms.add(restroom);
                    Log.v(TAG, "Added to restrooms ArrayList: " + restroom.getName());
                }
                Log.d(TAG, restrooms.size() + " restrooms added to ArrayList");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restrooms;
    }
}
