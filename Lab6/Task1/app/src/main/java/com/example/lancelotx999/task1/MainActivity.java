package com.example.lancelotx999.task1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity implements OnItemClickListener
{

    ListView AdobeList;
    String[] AdobeItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdobeList = (ListView)findViewById(R.id.AdobeList);
//
        String[] Adobe = getResources().getStringArray(R.array.adobe_product);
        AdobeItems = Adobe;
        CustomAdapter Adapter = new CustomAdapter(this, R.layout.list_item, Adobe);
        AdobeList.setAdapter(Adapter);

        AdobeList.setOnItemClickListener(this);

//        AdobeList.setOnItemClickListener(new OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
//            {
//                Toast toast = Toast.makeText(this, AdobeItems[arg2],10);
//                toast.show();
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        Toast toast = Toast.makeText(this, AdobeItems[arg2],10);
        toast.show();
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
