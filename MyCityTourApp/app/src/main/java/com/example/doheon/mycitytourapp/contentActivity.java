package com.example.doheon.mycitytourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); //여기까지 초기화
        gMap = new MapsActivity();
        wvf = new fragmenttwo();

        header= (TextView)findViewById(R.id.header);
        Intent intent = getIntent();
        locate = intent.getStringExtra("locate");
        weblink = intent.getStringExtra("link");
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

