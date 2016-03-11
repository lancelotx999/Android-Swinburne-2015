package com.example.lancelotx999.radiobutton;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MainActivity extends Activity {

    RadioButton RbBean;
    RadioButton RbKenny;
    RadioButton RbBart;

    RadioGroup RbGrpDisplay;

    ImageView ImageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RbBean = (RadioButton)findViewById(R.id.RbBean);
        RbKenny = (RadioButton)findViewById(R.id.RbKenny);
        RbBart = (RadioButton)findViewById(R.id.RbBart);
        RbGrpDisplay = (RadioGroup)findViewById(R.id.RbGrp);

        ImageDisplay = (ImageView)findViewById(R.id.ImgDisplay);

        RbGrpDisplay.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if (RbBean.isChecked())
                {
                    ImageDisplay.setImageDrawable(getResources().getDrawable(R.drawable.mrbean));
                }
                else if (RbKenny.isChecked())
                {
                    ImageDisplay.setImageDrawable(getResources().getDrawable(R.drawable.kenny));
                }
                else if (RbBart.isChecked())
                {
                    ImageDisplay.setImageDrawable(getResources().getDrawable(R.drawable.bart));
                }
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
