package com.example.lancelotx999.task2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.os.CountDownTimer;

public class MainActivity extends ActionBarActivity {

    TextView TvPos1;
    TextView TvPos2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvPos1 = (TextView)findViewById(R.id.TvPos1);
        TvPos2 = (TextView)findViewById(R.id.TvPos2);

        TvPos2.setVisibility(View.INVISIBLE);
        TvPos1.setVisibility(View.INVISIBLE);

        setContentView(R.layout.activity_main);
        new CountDownTimer(1000, 5000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                TvPos2.setVisibility(View.INVISIBLE);
                TvPos1.setVisibility(View.INVISIBLE);
            }

        }.start();

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
