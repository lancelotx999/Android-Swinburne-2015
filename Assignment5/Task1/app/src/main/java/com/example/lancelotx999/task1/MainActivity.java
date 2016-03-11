package com.example.lancelotx999.task1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity
{
    private Button BtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BtnMenu = (Button) findViewById(R.id.BtnMenu);
        BtnMenu.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, BtnMenu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.drop_down, popup.getMenu());

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

    }

    public void AddContact(MenuItem item)
    {
        Intent AddContactIntent = new Intent(this, AddContact.class);

        startActivity(AddContactIntent);
    }

    public void SearchContact(MenuItem item)
    {
        Intent SearchContactIntent = new Intent(this, SearchContact.class);

        startActivity(SearchContactIntent);
    }

    public void DeleteContact(MenuItem item)
    {
        Intent DeleteContactIntent = new Intent(this, DeleteContact.class);

        startActivity(DeleteContactIntent);
    }

    public void UpdateContact(MenuItem item)
    {
        Intent UpdateContactIntent = new Intent(this, UpdateContact.class);

        startActivity(UpdateContactIntent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
