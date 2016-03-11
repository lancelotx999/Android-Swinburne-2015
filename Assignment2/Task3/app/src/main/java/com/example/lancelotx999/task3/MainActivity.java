package com.example.lancelotx999.task3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView DisplayCentimetre;
    TextView DisplayMetre;

    EditText FieldFeet;
    EditText FieldInches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ConvertCentimetre(View view)
    {
        DisplayCentimetre = (TextView)findViewById(R.id.DisplayCentimetre);

        FieldFeet = (EditText)findViewById(R.id.FieldFeet);
        FieldInches = (EditText)findViewById(R.id.FieldInches);

        double Total;
        double Feet;
        double Inches;
        String FeetCheck = FieldFeet.getText().toString();
        String InchesCheck = FieldInches.getText().toString();

        if(FeetCheck.matches("")== false)
        {
            Feet = Double.parseDouble(FeetCheck);
        }
        else
        {
            Feet = 0;
        }

        if(InchesCheck.matches("")== false)
        {
            Inches = Double.parseDouble(InchesCheck);
        }
        else
        {
            Inches = 0;
        }

        Total = ( Feet * 30.48)+(Inches * 2.54) ;

        DisplayCentimetre.setText("Centimetre: " + Total);

    }

    public void ConvertMetre(View view)
    {
        DisplayMetre = (TextView)findViewById(R.id.DisplayMetre);

        FieldFeet = (EditText)findViewById(R.id.FieldFeet);
        FieldInches = (EditText)findViewById(R.id.FieldInches);

        double Total;
        double Feet;
        double Inches;
        String FeetCheck = FieldFeet.getText().toString();
        String InchesCheck = FieldInches.getText().toString();

        if(FeetCheck.matches("")== false)
        {
            Feet = Double.parseDouble(FeetCheck);
        }
        else
        {
            Feet = 0;
        }

        if(InchesCheck.matches("")== false)
        {
            Inches = Double.parseDouble(InchesCheck);
        }
        else
        {
            Inches = 0;
        }

        Total = ( Feet * 0.3048)+(Inches * 0.0254) ;

        DisplayMetre.setText("Metre: " + Total);

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
