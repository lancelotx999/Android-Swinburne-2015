package com.example.lancelotx999.task3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;


public class EnterInfo extends Activity {

    ImageView DisplayedImage;

    EditText Name;
    EditText Location;
    EditText Keywords;
    EditText Date;
    EditText Founder;

    RatingBar RatingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        Bundle ImageInformation = getIntent().getExtras();

        String ImageSelected = ImageInformation.getString("ImageSelected");

        DisplayedImage = (ImageView)findViewById(R.id.DisplayedImage);

        if (ImageSelected.equals("Apple"))
        {
            DisplayedImage.setImageDrawable(getResources().getDrawable(R.drawable.apple));
        }
        else if (ImageSelected.equals("Cheese"))
        {
            DisplayedImage.setImageDrawable(getResources().getDrawable(R.drawable.cheese));
        }
        else if (ImageSelected.equals("Pie"))
        {
            DisplayedImage.setImageDrawable(getResources().getDrawable(R.drawable.pie));
        }
        else if (ImageSelected.equals("Pizza"))
        {
            DisplayedImage.setImageDrawable(getResources().getDrawable(R.drawable.pizza));
        }
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

        Intent ImageDataIntent = new Intent(getApplicationContext(), DisplayInfo.class);

        ImageDataIntent.putExtra("ImageInformationExtra",ImageInformationParcel);

        startActivityForResult(ImageDataIntent, 0);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter_info, menu);
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
