package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.hardware.Camera.Parameters;


public class MainActivity extends Activity
{
    ImageView ImgBulb;
    TextView TxtStatus;
    int rotation;

    Parameters p;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgBulb = (ImageView)findViewById(R.id.ImgBulb);
        TxtStatus = (TextView)findViewById(R.id.TextStatus);

        camera = Camera.open();
        p = camera.getParameters();

        restoreState(savedInstanceState);

        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        rotation = display.getRotation();

        if(ImgBulb.getTag() == null || ImgBulb.getTag().toString().equals("Off"))
        {
            ImgBulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb_off));
            ImgBulb.setTag("Off");

            if (rotation == 1)
            {
                TxtStatus.setText("OFF");
            }

        }
        else
        {
            ImgBulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb_on));
            ImgBulb.setTag("On");

            if (rotation == 1)
            {
                TxtStatus.setText("ON");
            }

        }

        ImgBulb.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {

                if(ImgBulb.getTag() != null && ImgBulb.getTag().toString().equals("Off"))
                {
                    ImgBulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb_on));
                    ImgBulb.setTag("On");

                    if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
                    {

                        p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(p);
                        camera.startPreview();
                    }

                    if (rotation == 1)
                    {
                        TxtStatus.setText("ON");
                    }


                }
                else
                {
                    ImgBulb.setImageDrawable(getResources().getDrawable(R.drawable.bulb_off));
                    ImgBulb.setTag("Off");

                    if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
                    {
                        p.setFlashMode(Parameters.FLASH_MODE_OFF);
                        camera.setParameters(p);
                        camera.stopPreview();
                    }


                    if (rotation == 1)
                    {
                        TxtStatus.setText("OFF");
                    }

                }

                return false;

                //If return is true User must hold to keep light on
            }
        });


    }

//    public void SwitchOn(View view)
//    {
//        ImgBulb = (ImageView)findViewById(R.id.ImgBulb);
//
//    }

    @Override
    protected void onSaveInstanceState(Bundle state)
    {
        ImgBulb = (ImageView)findViewById(R.id.ImgBulb);

        String TextBulbStatus = ImgBulb.getTag().toString();

        state.putString("BulbStatus", TextBulbStatus);

        super.onSaveInstanceState(state);
    }

    protected void restoreState(Bundle state)
    {
        if (state == null)
        {
            return;
        }
        else
        {
            ImgBulb = (ImageView)findViewById(R.id.ImgBulb);

            String TextBulbStatus = state.getString("BulbStatus");

            ImgBulb.setTag(TextBulbStatus);
        }
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
