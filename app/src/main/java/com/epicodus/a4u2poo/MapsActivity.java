package com.epicodus.a4u2poo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.epicodus.a4u2poo.Models.Restroom;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.parceler.Parcels;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Restroom> restrooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        restrooms = (ArrayList<Restroom>) Parcels.unwrap(getIntent().getParcelableExtra("restrooms"));
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        for (int i = 0; i < restrooms.size(); i++) {
            double lat = restrooms.get(i).getLatitude();
            double longi = restrooms.get(i).getLongitude();
            String name = restrooms.get(i).getName();
            LatLng currentMarker = new LatLng(lat, longi);
            mMap.addMarker(new MarkerOptions().position(currentMarker).title(name));
        }
        double lat = restrooms.get(0).getLatitude();
        double longi = restrooms.get(0).getLongitude();
        LatLng firstMarker = new LatLng(lat, longi);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(firstMarker,15));
    }
}
