package com.sbpm.locationtracker;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.safety.locationlistenerhelper.core.LocationTracker;

public class LocationTrackerActivity extends AppCompatActivity {


    private LocationTracker locationTracker;

    private Button buttonLocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_tracker);

        buttonLocation = (Button) findViewById(R.id.btn_location);
        buttonLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationTracker = new LocationTracker("my.action")
                        .setInterval(1000)
                        .setGps(true)
                        .setNetWork(false)
                        .start(getBaseContext(),LocationTrackerActivity.this);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        locationTracker.onRequestPermission(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // locationTracker.stopLocationService(this);
    }
}
