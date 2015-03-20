package com.example.doheon.mycitytourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by DoHeon on 2015-03-17.
 */
public class contentActivity extends FragmentActivity {

    final int MAPIT = 0;
    final int INFO = 1;
    private int state = MAPIT; //0 = mapit, 1 = info

    String locate;
    String weblink;
    private TextView header; //화면 제일 상단의 스트링 나오는 부분의 id
    private  MapsActivity gMap = null;
    private fragmenttwo wvf = null;
    private float lat, lng;

    private final LatLng BUTIKPLATS = new LatLng(57.873873, 11.974995);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); //여기까지 초기화
        gMap = new MapsActivity();
        wvf = new fragmenttwo();
        header= (TextView)findViewById(R.id.header);
        Intent intent = getIntent();

        //get data
        locate = intent.getStringExtra("locate");
        weblink = intent.getStringExtra("link");
        lat = intent.getFloatExtra("latitude", 40.1f);
        lng = intent.getFloatExtra("longitude", 41.1f);

        //init data_webpage
        gMap.updateLatLng(lat, lng);
        header.setText("Tour "+ locate);
        wvf.init(weblink);
        state = MAPIT;

        getSupportFragmentManager().beginTransaction().add(R.id.fragcont, gMap).commit();
    }

    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_map:
                //Second는 Map의 Fragment이다.
                if(state!=MAPIT) {
                    //getFragmentManager().beginTransaction().
                    getFragmentManager().beginTransaction().remove(wvf).commit();
                    getSupportFragmentManager().beginTransaction().add(R.id.fragcont, gMap).commit();
                    state = MAPIT;
                }
                break;
            case R.id.button_info:
                //MapsActivity gMap_1 = new MapsActivity();
                if(state!=INFO) {
                    getSupportFragmentManager().beginTransaction().remove(gMap).commit();
                    getFragmentManager().beginTransaction().add(R.id.fragcont, wvf).commit();
                    state = INFO;
                }
                break;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "You've Just Watched Place "+ locate +"!", Toast.LENGTH_SHORT).show();
    }
}

