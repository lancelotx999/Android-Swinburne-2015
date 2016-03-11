package com.example.lancelotx999.task3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayInfo extends Activity {

    TextView Name;
    TextView Location;
    TextView Keywords;
    TextView Date;
    TextView Founder;
    TextView RatingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Name = (TextView)findViewById(R.id.DisplayName);
        Location = (TextView)findViewById(R.id.DisplayLocation);
        Keywords = (TextView)findViewById(R.id.DisplayKeywords);
        Date = (TextView)findViewById(R.id.DisplayDate);
        Founder = (TextView)findViewById(R.id.DisplayFounder);
        RatingImage = (TextView)findViewById(R.id.DisplayRating);

        // Fetching data from a parcelable object passed from MainActivity
        ImageData ImageDataInformation = getIntent().getParcelableExtra("ImageInformationExtra");


        if(ImageDataInformation !=null)
        {
            Name.setText("Name:"+ImageDataInformation.ImageName);
            Location.setText("Location:"+ ImageDataInformation.ImageLocation);
            Keywords.setText("Keywords:"+ImageDataInformation.ImageKeywords);
            Date.setText("Date:"+ImageDataInformation.ImageDate);
            Founder.setText("Founder:"+ImageDataInformation.ImageFounder);
            RatingImage.setText("Rating:"+ ImageDataInformation.ImageRating);
        }
        else
        {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_info, menu);
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
