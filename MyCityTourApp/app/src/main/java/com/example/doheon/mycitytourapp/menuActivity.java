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

        Intent intent = new Intent(this, MapsActivity.class);
        switch(view.getId())
        {
            case R.id.btn_1:
                startActivity(intent);
                break;
            case R.id.btn_2:
                startActivity(intent);
                break;
            case R.id.btn_3:
                startActivity(intent);
                break;
            case R.id.btn_4:
                startActivity(intent);
                break;
        }
    }
}
