package com.example.lancelotx999.task4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;


public class MainActivity extends Activity {


    EditText EditTextPassword;
    EditText EditTextUsername;
    Button BtnSubmit;
    String Password;
    String Username;

    Button TestShow;
    TextView ShowUsername;
    TextView ShowPassword;
    String RetrievePassword;
    String RetrieveUsername;

    SharedPreferences SharedPref;
    SharedPreferences.Editor Memory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditTextPassword = (EditText)findViewById(R.id.FieldPassword);
        EditTextUsername = (EditText)findViewById(R.id.FieldUsername);
        BtnSubmit = (Button)findViewById(R.id.BtnSubmit);

        SharedPref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        Memory = SharedPref.edit();


        BtnSubmit.setOnClickListener(new OnClickListener()
        {
            public void onClick(View argo)
            {
                Password = EditTextPassword.getText().toString();
                Username = EditTextUsername.getText().toString();



                // Storing data as KEY/VALUE pair
                Memory.putString("MemoryUsername", Username);
                Memory.putString("MemoryPassword", Password);

                // Save the changes in SharedPreferences
                Memory.commit(); // commit changes
            }

        });

        TestShow = (Button)findViewById(R.id.button);
        ShowUsername = (TextView)findViewById(R.id.textView2);
        ShowPassword = (TextView)findViewById(R.id.textView3);

        TestShow.setOnClickListener(new OnClickListener()
        {
            public void onClick(View argo)
            {
                RetrievePassword = SharedPref.getString("MemoryUsername", "NoSaveUsername").toString();
                RetrieveUsername = SharedPref.getString("MemoryPassword", "NoPassword").toString();

                ShowUsername.setText(RetrieveUsername);
                ShowPassword.setText(RetrievePassword);
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
