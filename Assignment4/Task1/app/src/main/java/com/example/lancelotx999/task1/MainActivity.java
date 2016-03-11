package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity implements OnItemClickListener
{
    ListView AddressList;
    InputStream TextNameList;
    BufferedReader Line = null;
    String line = null;

    ArrayAdapter<String> NameListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> NameList = new ArrayList<String>();

////        Working Raw Version
//        TextNameList = getResources().openRawResource(	R.raw.namelistfile);
//        try
//        {
//            Line = new BufferedReader(new InputStreamReader(TextNameList, "UTF-8"));
//        }
//        catch (UnsupportedEncodingException e1)
//        {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        String line = null;
//        try
//        {
//            while((line = Line.readLine()) !=null)
//            {
//                NameList.add(line);
//            }
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
////        End Of Working Raw Version


        try
        {

            TextNameList = this.getAssets().open("namelist.txt");
            Line = new BufferedReader(new InputStreamReader(TextNameList));

            try
            {
                while((line = Line.readLine()) !=null)
                {
                    NameList.add(line);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }

        AddressList = (ListView)findViewById(R.id.AddressList);
        NameListAdapter = new ArrayAdapter<String>(this, R.layout.list_item, NameList);
        AddressList.setAdapter( NameListAdapter );

        AddressList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        String selected =((TextView)arg1.findViewById(R.id.rowTextView)).getText().toString();

        Toast toast=Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT);
        toast.show();
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
