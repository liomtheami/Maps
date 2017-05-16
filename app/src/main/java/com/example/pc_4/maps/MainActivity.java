package com.example.pc_4.maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Button btnNormal = (Button) findViewById(R.id.id_btn_normal);
        btnNormal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });


        Button btnSatelite = (Button) findViewById(R.id.id_btn_satelite);
        btnSatelite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

            }
        });


        Button btnHibrido = (Button) findViewById(R.id.id_btn_normal);
        btnHibrido.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            }
        });




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapReady = true;

        LatLng pasto = new LatLng(1.2089284,-77.2779443);
        CameraPosition target = CameraPosition.builder().target(pasto).zoom(15).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));


    }
}
