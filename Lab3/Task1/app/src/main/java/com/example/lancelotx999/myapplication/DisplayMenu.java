package com.example.lancelotx999.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DisplayMenu extends Activity {

    TextView DisplayMeal;
    TextView DisplaySatisfaction;
    TextView DisplayRating;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);

        Bundle CustomerInformation = getIntent().getExtras();

        String MealType = CustomerInformation.getString("MealType");
        int Satisfaction = CustomerInformation.getInt("Satisfaction");
        Float Rating = CustomerInformation.getFloat("Rating");

        DisplayMeal = (TextView)findViewById(R.id.TextDisplayMeal);
        DisplaySatisfaction = (TextView)findViewById(R.id.TextDisplaySatisfaction);
        DisplayRating = (TextView)findViewById(R.id.TextDisplayRating);

        DisplayMeal.setText(MealType);
        DisplaySatisfaction.setText(Integer.toString(Satisfaction) + "%");
        DisplayRating.setText(Rating.toString() + " Stars");


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_display_menu, menu);
//        return true;
//    }

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
