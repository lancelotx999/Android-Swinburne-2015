package com.example.lancelotx999.task1;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import android.widget.AdapterView.OnItemClickListener;

import org.w3c.dom.Text;


public class UpdateContact extends Activity implements OnItemClickListener
{
    ListView AddressList;

    ArrayAdapter<String> NameListAdapter;
    ArrayList<String> AddressBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        ArrayList<String> NameList = new ArrayList<String>();
        AddressBookList = new ArrayList<String>();

        SQLiteDatabase SqlAddressBookList= null;

        String Data="";

        try
        {
            SqlAddressBookList = this.openOrCreateDatabase("AddressBookList", MODE_PRIVATE, null);

            /* Create a Table in the Database. */
            SqlAddressBookList.execSQL("CREATE TABLE IF NOT EXISTS "+ "AddressBookList"+ " (Name VARCHAR, Address VARCHAR, Contact VARCHAR, Email VARCHAR);");

            /* Insert data to a Table*/
//            AddressBookList.execSQL("INSERT INTO " + "AddressBookList"+ " (Name, Address, Contact, Email)" + " VALUES ('Sean Lee', 'Swinburne', '016-123456','4308131@students.swinburne.edu.my');");

            /*retrieve data from database */
            Cursor c = SqlAddressBookList.rawQuery("SELECT * FROM " + "AddressBookList" , null);

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

                    NameList.add(Name);
                    AddressBookList.add(Name+","+Address+","+Contact+","+Email+"\n");
//                    Data =Data +"Name:  "+Name+"\n"+"Address:  "+Address+"\n"+"Contact:  "+Contact+"\n"+"Email:  "+Email+"\n";
                }while(c.moveToNext());
            }
//            TextView tv = (TextView)findViewById(R.id.textView);
//            tv.setText(Data);
//            setContentView(tv);
        }
        catch(Exception e)
        {
            Log.e("Error", "Error", e);
        }
        finally
        {
            if (SqlAddressBookList != null)
                SqlAddressBookList.close();
        }


        AddressList = (ListView)findViewById(R.id.ListName);
        NameListAdapter = new ArrayAdapter<String>(this, R.layout.list_name, NameList);
        AddressList.setAdapter( NameListAdapter );

        AddressList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3)
    {
        StringTokenizer tokens = new StringTokenizer(AddressBookList.get(arg2), ",");
        final String Name = tokens.nextToken();
        final String Address = tokens.nextToken();
        final String Contact = tokens.nextToken();
        final String Email = tokens.nextToken();

        final Dialog CustomDialog = new Dialog(this);
        CustomDialog.setContentView(R.layout.updatecontact);
        CustomDialog.show();

        Button BtnClose = (Button) CustomDialog.findViewById(R.id.BtnClose);
        Button BtnUpdateContact = (Button)CustomDialog.findViewById(R.id.BtnUpdateContact);
        EditText FieldName = (EditText)CustomDialog.findViewById(R.id.FieldUpdateName);
        EditText FieldAddress = (EditText)CustomDialog.findViewById(R.id.FieldUpdateAddress);
        EditText FieldContact = (EditText)CustomDialog.findViewById(R.id.FieldUpdateContact);
        EditText FieldEmail = (EditText)CustomDialog.findViewById(R.id.FieldUpdateEmail);

        FieldName.setText(Name, TextView.BufferType.EDITABLE);
        FieldAddress.setText(Address, TextView.BufferType.EDITABLE);
        FieldContact.setText(Contact, TextView.BufferType.EDITABLE);
        FieldEmail.setText(Email, TextView.BufferType.EDITABLE);

        BtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.dismiss();
            }
        });

        BtnUpdateContact.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                SQLiteDatabase SqlAddressBookList= getBaseContext().openOrCreateDatabase("AddressBookList", MODE_PRIVATE, null);

                try
                {

                    ContentValues cv = new ContentValues();

                    EditText FieldName = (EditText)CustomDialog.findViewById(R.id.FieldUpdateName);
                    EditText FieldAddress = (EditText)CustomDialog.findViewById(R.id.FieldUpdateAddress);
                    EditText FieldContact = (EditText)CustomDialog.findViewById(R.id.FieldUpdateContact);
                    EditText FieldEmail = (EditText)CustomDialog.findViewById(R.id.FieldUpdateEmail);

                    cv.put("Name",FieldName.getText().toString()); //These Fields should be your String values of actual column names
                    cv.put("Address",FieldAddress.getText().toString());
                    cv.put("Contact",FieldContact.getText().toString());
                    cv.put("Email",FieldEmail.getText().toString());


                    SqlAddressBookList.update("AddressBookList", cv, "Name = " + "'" + Name + "'", null);
                }
                catch(Exception e)
                {
                    Log.e("Error", "Error", e);
                }
                finally
                {
                    if (SqlAddressBookList != null)
                        SqlAddressBookList.close();
                }

                Intent MainActivity = new Intent(getBaseContext(), MainActivity.class);

                startActivity(MainActivity);

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_contact, menu);
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
