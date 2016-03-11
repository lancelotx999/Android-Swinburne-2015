package com.example.lancelotx999.task1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailPage extends Activity {

    ImageView imgView;
    TextView castTxt, sypnosisTxt;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        movie movie=(movie)getIntent().getParcelableExtra("details");

        if (movie!=null)
            display_details(movie);
    }

    private void display_details(movie mov)
    {

        Integer imgID;

        imgView=(ImageView)findViewById(R.id.imageView1);
        castTxt=(TextView)findViewById(R.id.txtCastList);
        sypnosisTxt=(TextView)findViewById(R.id.Sypnosis);

        setTitle(mov.getTitle());
        imgID=getResources().getIdentifier(mov.getMovieIcon(),"drawable",getApplicationContext().getPackageName());
        getActionBar().setIcon(imgID);
        //Log.d("casts",mov.getCast());
        imgID=getResources().getIdentifier(mov.getImage(),"drawable",getApplicationContext().getPackageName());
        imgView.setImageResource(imgID);

        castTxt.setText(mov.getCast());
        sypnosisTxt.setText(mov.getSypnosis());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_page, menu);
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
