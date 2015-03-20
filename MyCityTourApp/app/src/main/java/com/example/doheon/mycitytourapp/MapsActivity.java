package com.example.doheon.mycitytourapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends SupportMapFragment {

    private GoogleMap googleMap;
    LatLng cur_Latlng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        googleMap = getMap();
        initMap();
        return v;
        //return inflater.inflate(R.layout.activity_maps, null);
    }

    //@Override
    //public void onActivityCreated(Bundle savedInstanceState)
    //{
        //super.onActivityCreated(savedInstanceState);
       // googleMap = getMap();
     //   googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
   // }

    private void initMap() {
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(cur_Latlng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(16));

        //googleMap.getUiSettings().setZoomControlsEnabled(true);

        //UiSettings settings = googleMap.getUiSettings();
        //settings.setAllGesturesEnabled(true);
        //settings.setMyLocationButtonEnabled(false);
        // getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(lat,16));
        googleMap.addMarker(new MarkerOptions().position(cur_Latlng));
    }
    public void updateLatLng(float lat, float lng) {
        cur_Latlng = new LatLng(lat, lng);
    }
}

//googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
