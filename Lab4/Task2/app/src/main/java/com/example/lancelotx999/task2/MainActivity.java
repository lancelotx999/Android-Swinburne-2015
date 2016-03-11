package com.example.lancelotx999.task2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.os.Parcelable;



import java.util.ArrayList;


public class MainActivity extends Activity {

    EditText Name;
    EditText Location;
    EditText Keywords;
    EditText Date;
    EditText Founder;

    RatingBar RatingImage;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ShareImage(View view)
    {
        Name = (EditText)findViewById(R.id.FieldName);
        Location = (EditText)findViewById(R.id.FieldLocation);
        Keywords = (EditText)findViewById(R.id.FieldKeywords);
        Date = (EditText)findViewById(R.id.FieldDate);
        Founder = (EditText)findViewById(R.id.FieldFounder);

        RatingImage = (RatingBar)findViewById(R.id.RatingImage);

        ImageData ImageInformationParcel = new ImageData(Name.getText().toString(),Location.getText().toString(),Keywords.getText().toString(), Date.getText().toString(), Founder.getText().toString(), RatingImage.getRating());

        Intent ImageDataIntent = new Intent(getApplicationContext(), ImageInformationDisplay.class);

        ImageDataIntent.putExtra("ImageInformationExtra",ImageInformationParcel);

        startActivityForResult(ImageDataIntent, 0);
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
