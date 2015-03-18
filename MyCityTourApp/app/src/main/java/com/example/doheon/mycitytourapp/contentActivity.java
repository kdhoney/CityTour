package com.example.doheon.mycitytourapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

/**
 * Created by DoHeon on 2015-03-17.
 */
public class contentActivity extends FragmentActivity {

    public static FragmentManager fragmeManager;
    private com.google.android.gms.maps.SupportMapFragment smapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); //여기까지 초기화





        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft = getSupportFragmentManager().beginTransaction();
        MapsActivity gMap = new MapsActivity(); //Second는 Map의 Fragment이다.
        ft.add(R.id.fragcont, gMap);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_map:
                Toast.makeText(this, "button_Map_it", Toast.LENGTH_SHORT).show();
                //fr = new fragmentone();
                break;
            case R.id.button_info:
                Toast.makeText(this, "button_Info", Toast.LENGTH_SHORT).show();
               // fr = new fragmenttwo();
                break;
        }

       // FragmentManager fm = getFragmentManager();
       // FragmentTransaction fragmentTransaction = fm.beginTransaction();
       // fragmentTransaction.replace(R.id.fragcont, fr);
      //  fragmentTransaction.commit();
    }
    //int mCurrentFragmentIndex;
    //public final static int FRAGMENT_MAP = 0;
   // public final static int FRAGMENT_WEB = 1;

    //private com.google.android.gms.maps.SupportMapFragment smapFragment;
   // private GoogleMap googleMap;


    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "You've Just Satched Place #1!", Toast.LENGTH_SHORT).show();
    }
}

