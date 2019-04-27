package com.example.administrador.scrapmeteo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        final LatLng vistabella = new LatLng(40.2961700, -0.2943500);
        final LatLng xodos = new LatLng(40.244979, -0.286952);
        final LatLng adzaneta = new LatLng(40.216349, -0.170869);
        final LatLng villafranca = new LatLng(40.441129, -0.271394);
        final LatLng valdelinares = new LatLng(40.3778900, -0.6313300);
        final LatLng villamalur = new LatLng(39.9611500, -0.4030500);
        final LatLng onda = new LatLng(39.96667, -0.25);
        final LatLng alcala = new LatLng(40.3568900, -0.6977600);
        final LatLng toro = new LatLng(39.982458, -0.748406);
        final LatLng puebla = new LatLng(40.045139, -1.14484);
        final LatLng mosqueruela = new LatLng(40.361389, -0.448889);
        final LatLng montanejos = new LatLng(	40.068003, -0.523247);
        final LatLng bronchales = new LatLng(40.508991, -1.58853);


        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        // Add a marker in Vistabella and move the camera
        //LatLng cs = new LatLng(40.2961700, -0.2943500);

        mMap.addMarker(new MarkerOptions().position(vistabella).title("Vistabella"));
        mMap.addMarker(new MarkerOptions().position(xodos).title("xodos"));
        mMap.addMarker(new MarkerOptions().position(bronchales).title("bronchales"));
        mMap.addMarker(new MarkerOptions().position(mosqueruela).title("mosqueruela"));
        mMap.addMarker(new MarkerOptions().position(toro).title("toro"));
        mMap.addMarker(new MarkerOptions().position(villafranca).title("villafranca"));
        mMap.addMarker(new MarkerOptions().position(valdelinares).title("valdelinares"));
        mMap.addMarker(new MarkerOptions().position(villamalur).title("villamalur"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(cs));
    }
}
