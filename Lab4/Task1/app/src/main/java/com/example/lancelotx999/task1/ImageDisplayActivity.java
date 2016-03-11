package com.example.lancelotx999.task1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageDisplayActivity extends Activity {

    ImageView EnlargedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);

        Bundle ImageInformation = getIntent().getExtras();

        String ImageSelected = ImageInformation.getString("ImageSelected");

        EnlargedImage = (ImageView)findViewById(R.id.ImageEnlarged);

        if (ImageSelected.equals("Apple"))
        {
            EnlargedImage.setImageDrawable(getResources().getDrawable(R.drawable.apple));
        }
        else if (ImageSelected.equals("Cheese"))
        {
            EnlargedImage.setImageDrawable(getResources().getDrawable(R.drawable.cheese));
        }
        else if (ImageSelected.equals("Pie"))
        {
            EnlargedImage.setImageDrawable(getResources().getDrawable(R.drawable.pie));
        }
        else if (ImageSelected.equals("Pizza"))
        {
            EnlargedImage.setImageDrawable(getResources().getDrawable(R.drawable.pizza));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_display, menu);
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
