package com.example.eliad.busapp;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import 	android.widget.SimpleCursorAdapter;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.eliad.busapp.R.id.dynamic;
import static com.example.eliad.busapp.R.id.map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String[] GpsPermissions= {android.Manifest.permission.ACCESS_FINE_LOCATION};
    private LocationManager locationMangaer=null;
    private LocationListener locationListener=null;
    private SimpleCursorAdapter linesList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);





        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }




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
        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

       // Location lastLocation = locationMangaer.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        LatLng location = new LatLng(-34, 151);

        //Draw my location on map
        mMap.addMarker(new MarkerOptions().position(location).title("sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

        //Zoom the map
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);



        /*
        //activate location listner to auto locate the device
        locationListener = new MyLocationListener();
        locationMangaer.requestLocationUpdates(
           LocationManager.NETWORK_PROVIDER, 3, 10, locationListener);
        */



    }

    /*----------Listener class to get coordinates ------------- */
    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {

            LatLng location = new LatLng(loc.getLongitude(), loc.getLatitude());

            mMap.addMarker(new MarkerOptions().position(location).title("Unknpwn"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));

        }


        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}

