package com.example.lancelotx999.task2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class GetProfile extends Activity {

    EditText UserName;
    EditText UserEmail;

    ImageView ImageSean;

    SharedPreferences UserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_profile);

        UserData = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        UserName = (EditText)findViewById(R.id.TxtName);
        UserEmail = (EditText)findViewById(R.id.TxtEmail);

        if (UserData.contains("name"))
        {
            UserName.setText(UserData.getString("name", ""));

        }
        if (UserData.contains("email"))
        {
            UserEmail.setText(UserData.getString("email", ""));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_profile, menu);
        return true;
    }

    public void GetImage(View view)
    {
        UserName = (EditText)findViewById(R.id.TxtName);
        UserEmail = (EditText)findViewById(R.id.TxtEmail);

        if (UserName.getText().toString().equals("Sean") && UserEmail.getText().toString().equals("Sean@sean.com"))
        {
            ImageSean = (ImageView)findViewById(R.id.ImgSean);

            //Deprecated in api22
            ImageSean.setImageDrawable(getResources().getDrawable(R.drawable.symbol));
        }
    }

    public void Submit(View view)
    {
        UserName = (EditText)findViewById(R.id.TxtName);
        UserEmail = (EditText)findViewById(R.id.TxtEmail);

//        UserData UserInformationParcel = new UserData(UserName.getText().toString(), UserEmail.getText().toString());

        SharedPreferences.Editor UserDataEdit = UserData.edit();

        UserDataEdit.putString("name", UserName.getText().toString());
        UserDataEdit.putString("email", UserEmail.getText().toString());

        UserDataEdit.commit();

        Bundle UserDataBundle = new Bundle();
        Intent UserInformationIntent = new Intent(getApplicationContext(),MainActivity.class);

        UserDataBundle.putParcelable("UserData", new UserData(UserName.getText().toString(), UserEmail.getText().toString()) );
        UserInformationIntent.putExtras(UserDataBundle);

//        UserInformationIntent.putExtra("UserInformationExtra", UserInformationParcel);

        startActivityForResult(UserInformationIntent,0);
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
