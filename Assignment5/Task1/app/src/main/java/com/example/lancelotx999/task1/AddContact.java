package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddContact extends Activity
{
    Button BtnAdd;

    EditText FieldName;
    EditText FieldContact;
    EditText FieldAddress;
    EditText FieldEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        BtnAdd = (Button)findViewById(R.id.BtnAddContact);
    }

    public void AddContact(View view)
    {
        FieldName = (EditText)findViewById(R.id.FieldName);
        FieldContact = (EditText)findViewById(R.id.FieldUpdateContact);
        FieldAddress = (EditText)findViewById(R.id.FieldUpdateAddress);
        FieldEmail = (EditText)findViewById(R.id.FieldEmail);

        SQLiteDatabase AddressBookList= null;

        String Data="";

        /* Create a Database. */
        try
        {
            AddressBookList = this.openOrCreateDatabase("AddressBookList", MODE_PRIVATE, null);

            /* Create a Table in the Database. */
            AddressBookList.execSQL("CREATE TABLE IF NOT EXISTS "+ "AddressBookList"+ " (Name VARCHAR, Address VARCHAR, Contact VARCHAR, Email VARCHAR);");

            /* Insert data to a Table*/
            AddressBookList.execSQL("INSERT INTO " + "AddressBookList"+ " (Name, Address, Contact, Email)" + " VALUES ('"+ FieldName.getText().toString()+"', '"+ FieldAddress.getText().toString()+"', '"+ FieldContact.getText().toString()+"','"+ FieldEmail.getText().toString()+"');");

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

        Intent MainActivity = new Intent(this, MainActivity.class);

        startActivity(MainActivity);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
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
