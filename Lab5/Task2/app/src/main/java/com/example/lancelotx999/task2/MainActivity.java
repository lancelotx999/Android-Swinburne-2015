package com.example.lancelotx999.task2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends Activity
{

    FileInputStream TextFileInput;
    ListView DisplayNameList;

    ArrayAdapter<String> NameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream TextNameList = getResources().openRawResource(	R.raw.namelistfile);
        BufferedReader Line = null;

        try
        {
            Line = new BufferedReader(new InputStreamReader(TextNameList, "UTF-8"));
        }
        catch (UnsupportedEncodingException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        ArrayList<String> NameList = new ArrayList<String>();

        String line = null;
        try {
            while((line = Line.readLine()) !=null)NameList.add(line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        DisplayNameList = (ListView)findViewById(R.id.ListName);
        NameListAdapter = new ArrayAdapter<String>(this, R.layout.listviewlayout, NameList);
        DisplayNameList.setAdapter( NameListAdapter );
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
