package com.example.doheon.mycitytourapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

//import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.FragmentTransaction;

/**
 * Created by DoHeon on 2015-03-17.
 */
public class contentActivity extends FragmentActivity {

    public FragmentManager fManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); //여기까지 초기화
        //fManager = getSupportFragmentManager();


        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft = getSupportFragmentManager().beginTransaction();
        //MapsActivity gMap = new MapsActivity(); //Second는 Map의 Fragment이다.
        //ft.add(R.id.fragcont, gMap);
        //ft.addToBackStack(null);
        //ft.commit();
    }

    public void onClick(View view) {

        //FragmentManager fragmentManager = getFragmentManager();

        //Fragment fragment = new Fragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.button_map:

                MapsActivity gMap = new MapsActivity(); //Second는 Map의 Fragment이다.
                ft.add(R.id.fragcont, gMap);
                ft.addToBackStack(null);
                ft.commit();
                //Toast.makeText(this, "button_Map_it", Toast.LENGTH_SHORT).show();

                break;
            case R.id.button_info:
                fragmenttwo wvf = new fragmenttwo();
               // Toast.makeText(this, "button_Info", Toast.LENGTH_SHORT).show();
                //Intent i = this.getIntent();
                //String link = i.getExtras().getString("link");
                wvf.init("http://www.naver.com/");
                getFragmentManager().beginTransaction().add(R.id.fragcont, wvf).commit();
                break;
        }
       // fragmentManager.beginTransaction().replace(R.id.fragcont, fragment).commit();

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

