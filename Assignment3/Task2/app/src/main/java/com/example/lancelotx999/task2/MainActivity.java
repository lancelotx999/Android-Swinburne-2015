package com.example.lancelotx999.task2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    TextView UserName;
    TextView UserEmail;

    ImageView ImageSean;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (TextView)findViewById(R.id.TextName);
        UserEmail = (TextView)findViewById(R.id.TextEmail);

//        UserData UserInformation = getIntent().getParcelableExtra("UserInformationExtra");
        UserData UserInformation = (UserData)getIntent().getParcelableExtra("UserData");

        if(UserInformation != null)
        {
            if (UserInformation.UserName.equals("Sean") && UserInformation.UserEmail.equals("Sean@sean.com"))
            {
                ImageSean = (ImageView)findViewById(R.id.ImgSean);
                UserName = (TextView)findViewById(R.id.TextName);
                UserEmail = (TextView)findViewById(R.id.TextEmail);

                ImageSean.setImageDrawable(getResources().getDrawable(R.drawable.symbol));
                UserName.setText("Name: " + UserInformation.UserName);
                UserEmail.setText("Email: " + UserInformation.UserEmail);
            }
        }

    }

    public void GetProfile(View view)
    {
        Intent GetProfileIntent = new Intent(this, GetProfile.class);

        startActivity(GetProfileIntent);
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
