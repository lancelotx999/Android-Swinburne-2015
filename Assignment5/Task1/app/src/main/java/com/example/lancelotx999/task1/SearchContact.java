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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;


public class SearchContact extends Activity
{
    EditText FieldSearch;

    Button BtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        BtnSearch = (Button)findViewById(R.id.BtnSearch);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_contact, menu);
        return true;
    }

    public void SearchContact(View view)
    {
        FieldSearch = (EditText)findViewById(R.id.FieldSearch);

        SQLiteDatabase AddressBookList= null;

        String Data="";

        /* Create a Database. */
        try
        {
            AddressBookList = this.openOrCreateDatabase("AddressBookList", MODE_PRIVATE, null);
            String SearchParameter = FieldSearch.getText().toString();
            if (SearchParameter.length() != 0) {
                SearchParameter = "%" + SearchParameter + "%";
            }

            Cursor c = AddressBookList.rawQuery("select * from AddressBookList where " + "Name like  '"+ SearchParameter + "'" + "or Address like  '"+ SearchParameter + "'" + "or Contact like  '"+ SearchParameter + "'" + "or Email like  '"+ SearchParameter + "'" , null);

            int Column1 = c.getColumnIndex("Name");
            int Column2 = c.getColumnIndex("Address");
            int Column3 = c.getColumnIndex("Contact");
            int Column4 = c.getColumnIndex("Email");

            // Check if our result was valid.
            c.moveToFirst();
            if (c != null)
            {
                // Loop through all Results
                do
                {
                    String Name = c.getString(Column1);
                    String Address = c.getString(Column2);
                    String Contact = c.getString(Column3);
                    String Email = c.getString(Column4);
                    Data =Data +"Name:  "+Name+"\n"+"Address:  "+Address+"\n"+"Contact:  "+Contact+"\n"+"Email:  "+Email+"\n";
                }while(c.moveToNext());
            }

            final Dialog CustomDialog = new Dialog(this);
            CustomDialog.setContentView(R.layout.searchresult);
            CustomDialog.show();

            TextView TextSearchResult = (TextView)CustomDialog.findViewById(R.id.TextSearchResult);

            TextSearchResult.setText(Data);

            Button BtnClose = (Button) CustomDialog.findViewById(R.id.BtnClose);

            BtnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CustomDialog.dismiss();
                }
            });
        }
        catch(Exception e)
        {
            Log.e("Error", "Error", e);
        }
        finally
        {
            if (AddressBookList != null)
                AddressBookList.close();
        }

//        Intent MainActivity = new Intent(this, MainActivity.class);
//
//        startActivity(MainActivity);

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
