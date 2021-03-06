package com.example.doheon.mycitytourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    private EditText logid;
    private EditText logpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logid = (EditText)findViewById(R.id.login_id);
        logpw = (EditText)findViewById(R.id.login_pw);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, menuActivity.class);
        startActivity(intent);
       // if(logid.getText().toString().equals("abcd")==true && logpw.getText().toString().equals("1234")) {
         //   Intent intent = new Intent(this, menuActivity.class);
           // startActivity(intent);
       // }
        //else {
          //  Toast.makeText(this, "id, password 오류", Toast.LENGTH_SHORT).show();
        //}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
