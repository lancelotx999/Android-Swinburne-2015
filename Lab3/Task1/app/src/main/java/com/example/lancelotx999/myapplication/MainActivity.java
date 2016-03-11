package com.example.lancelotx999.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView TxtRating;
    TextView TxtSatisfaction;
    TextView TxtMeal;

    RadioGroup RbGrpMeal;
    RadioButton RbBreakfast;
    RadioButton RbLunch;
    RadioButton RbDinner;

    RatingBar RatingSatisfaction;

    SeekBar BarRatingSatisfaction;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void DisplayMenu(View view)
    {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);

        TxtRating = (TextView)findViewById(R.id.TextRating);
        TxtSatisfaction = (TextView)findViewById(R.id.TextSatisfaction);
        TxtMeal = (TextView)findViewById(R.id.TextMeal);

        RbGrpMeal = (RadioGroup)findViewById(R.id.RbgrpMeal);
        RbBreakfast = (RadioButton)findViewById(R.id.RbBreakfast);
        RbLunch = (RadioButton)findViewById(R.id.RbLunch);
        RbDinner = (RadioButton)findViewById(R.id.RbDinner);

        RatingSatisfaction = (RatingBar)findViewById(R.id.RatingSatisfaction);

        BarRatingSatisfaction = (SeekBar)findViewById(R.id.BarSatisfaction);

        Intent DisplayIntent = new Intent(this, DisplayMenu.class);

        Bundle CustomerInformation = new Bundle();

        if (RbBreakfast.isChecked())
        {
            CustomerInformation.putString("MealType", "Breakfast");
        }
        else if (RbLunch.isChecked())
        {
            CustomerInformation.putString("MealType", "Lunch");
        }
        else if (RbDinner.isChecked())
        {
            CustomerInformation.putString("MealType", "Dinner");
        }

        CustomerInformation.putInt("Satisfaction", BarRatingSatisfaction.getProgress());
        CustomerInformation.putFloat("Rating", RatingSatisfaction.getRating());
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
        DisplayIntent.putExtras(CustomerInformation);
        startActivity(DisplayIntent);

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
