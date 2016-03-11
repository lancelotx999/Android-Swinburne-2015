package com.example.lancelotx999.task4;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MainActivity extends Activity {

    Calendar CurrentTime;
    TextView DisplayCurrentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GetTimeDate(View view)
    {
        CurrentTime = Calendar.getInstance();

        DisplayCurrentTime = (TextView)findViewById(R.id.DisplayTimeDate);

        Date CurrentTime = Calendar.getInstance().getTime();
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String TimeString = DateFormat.format(CurrentTime);

        DisplayCurrentTime.setText(TimeString);
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
