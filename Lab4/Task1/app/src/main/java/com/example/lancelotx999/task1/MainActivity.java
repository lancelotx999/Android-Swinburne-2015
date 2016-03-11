package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    ImageView Apple;
    ImageView Cheese;
    ImageView Pie;
    ImageView Pizza;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnlargeImageApple(View view)
    {
        Apple = (ImageView)findViewById(R.id.ImageApple);

        Intent ImageDisplayIntent = new Intent(this, ImageDisplayActivity.class);

        Bundle ImageInformation = new Bundle();

        ImageInformation.putString("ImageSelected", "Apple");

        ImageDisplayIntent.putExtras(ImageInformation);
        startActivity(ImageDisplayIntent);

    }

    public void EnlargeImageCheese(View view)
    {

        Cheese = (ImageView)findViewById(R.id.ImageCheese);

        Intent ImageDisplayIntent = new Intent(this, ImageDisplayActivity.class);

        Bundle ImageInformation = new Bundle();

        ImageInformation.putString("ImageSelected", "Cheese");

        ImageDisplayIntent.putExtras(ImageInformation);
        startActivity(ImageDisplayIntent);

    }

    public void EnlargeImagePie(View view)
    {
        Pie = (ImageView)findViewById(R.id.ImagePie);

        Intent ImageDisplayIntent = new Intent(this, ImageDisplayActivity.class);

        Bundle ImageInformation = new Bundle();

        ImageInformation.putString("ImageSelected", "Pie");

        ImageDisplayIntent.putExtras(ImageInformation);
        startActivity(ImageDisplayIntent);

    }

    public void EnlargeImagePizza(View view)
    {
        Pizza = (ImageView)findViewById(R.id.ImagePizza);

        Intent ImageDisplayIntent = new Intent(this, ImageDisplayActivity.class);

        Bundle ImageInformation = new Bundle();

        ImageInformation.putString("ImageSelected", "Pizza");

        ImageDisplayIntent.putExtras(ImageInformation);
        startActivity(ImageDisplayIntent);

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
