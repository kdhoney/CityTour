package com.example.doheon.mycitytourapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DoHeon on 2015-03-17.
 */
public class contentActivity extends FragmentActivity {

    String locate;
    String weblink;
    private TextView header; //화면 제일 상단의 스트링 나오는 부분의 id

     public FragmentManager fManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content); //여기까지 초기화
        header= (TextView)findViewById(R.id.header);

        Intent intent = getIntent();
        locate = intent.getStringExtra("locate");
        weblink = intent.getStringExtra("link");

        header.setText("Tour "+ locate);
    }

    public void onClick(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.button_map:
                MapsActivity gMap = new MapsActivity(); //Second는 Map의 Fragment이다.
                ft.add(R.id.fragcont, gMap);
                ft.addToBackStack(null);
                ft.commit();

                break;
            case R.id.button_info:
                fragmenttwo wvf = new fragmenttwo();
                wvf.init(weblink);
                getFragmentManager().beginTransaction().add(R.id.fragcont, wvf).commit();
                break;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "You've Just Watched Place "+ locate +"!", Toast.LENGTH_SHORT).show();
    }
}

