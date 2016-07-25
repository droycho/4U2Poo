package com.epicodus.a4u2poo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.a4u2poo.Models.Restroom;
import com.epicodus.a4u2poo.Services.RefugeService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {
    public static final String TAG = DetailActivity.class.getSimpleName();

    public ArrayList<Restroom> mRestrooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getRestrooms("Portland");
    }

    private void getRestrooms(String location) {
        final RefugeService refugeService = new RefugeService();
        refugeService.queryRefuge(45.5231, -122.6765, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {
                    mRestrooms = refugeService.processResults(response);
//                        Log.d(TAG, mRestrooms.get(0).toString());
                }

            }
        });
    }

}
