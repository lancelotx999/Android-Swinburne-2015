package com.example.lancelotx999.task4;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    TextView Textdisplay;
    Button BtnClick;
    Button BtnPush;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Textdisplay = (TextView)findViewById(R.id.TvTextdisplay);
        Textdisplay.setText(String.valueOf(count));
        BtnClick = (Button)findViewById(R.id.BtnClick);

        BtnClick.setOnClickListener(new OnClickListener()
        {
            public void onClick(View arg0)
            {
                count++;
                Textdisplay.setText("I was clicked " + String.valueOf(count)+ " times.");
            }
        });

        BtnPush = (Button)findViewById(R.id.BtnPush);
        BtnPush.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Textdisplay.setText("Button 1 Pressed.");
            }
        });
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
