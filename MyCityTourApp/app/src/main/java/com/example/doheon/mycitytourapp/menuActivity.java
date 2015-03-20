package com.example.doheon.mycitytourapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by DoHeon on 2015-03-16.
 */
public class menuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, contentActivity.class);

        switch(view.getId())
        {
            case R.id.btn_1:
                intent.putExtra("locate", "남산 팔각정");
                intent.putExtra("link", "http://terms.naver.com/entry.nhn?docId=1999814&cid=42856&categoryId=42856");
                intent.putExtra("latitude", 37.55157798469981f);
                intent.putExtra("longitude", 126.98770523071289f);
                startActivity(intent);
                break;
            case R.id.btn_2:
                intent.putExtra("locate", "숭례문");
                intent.putExtra("link", "http://terms.naver.com/entry.nhn?docId=1111278&cid=40942&categoryId=33383");
                intent.putExtra("latitude", 37.560031f);
                intent.putExtra("longitude", 126.97535f);
                startActivity(intent);
                break;
            case R.id.btn_3:
                intent.putExtra("locate", "63빌딩");
                intent.putExtra("link", "http://terms.naver.com/entry.nhn?docId=1081761&cid=40942&categoryId=33083");
                intent.putExtra("latitude", 37.520697f);
                intent.putExtra("longitude", 126.939736f);
                startActivity(intent);
                break;
            case R.id.btn_4:
                intent.putExtra("locate", "경복궁");
                intent.putExtra("link", "http://terms.naver.com/entry.nhn?docId=1059958&cid=40942&categoryId=33079");
                intent.putExtra("latitude", 37.575776f);
                intent.putExtra("longitude", 126.977733f);
                startActivity(intent);
                break;
        }
    }
}