package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    ListView ListMovie;

    ArrayList<movie> MovieList;
    movie TempMovie;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListMovie = (ListView)findViewById(R.id.ListMovie);

        try
        {
            SAXParserFactory saxparser = SAXParserFactory.newInstance();
            SAXParser parser = saxparser.newSAXParser();
            XMLReader xmlReader = parser.getXMLReader();
            XMLParser XMLParser = new XMLParser();
            xmlReader.setContentHandler(XMLParser);
            InputStream is = getAssets().open("movie_list.xml");
            xmlReader.parse(new InputSource(is));
            MovieData ListMovieData = new MovieData(this, XMLParser.Title, XMLParser.Rating, XMLParser.Genre, XMLParser.Synopsis, XMLParser.Cast, XMLParser.ImageIcon, XMLParser.Image);





            ListMovie.setAdapter(ListMovieData);

        }
        catch (Exception e)
        {
            e.getMessage();
        }

        ListMovie.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id)
            {

//                    String item = ((TextView)view).getText().toString();


                try
                {
                    SAXParserFactory saxparser = SAXParserFactory.newInstance();
                    SAXParser parser = saxparser.newSAXParser();
                    XMLReader xmlReader = parser.getXMLReader();
                    XMLParser XMLParser = new XMLParser();
                    xmlReader.setContentHandler(XMLParser);
                    InputStream is = getAssets().open("movie_list.xml");
                    xmlReader.parse(new InputSource(is));

                    movie movieParcel = new movie();

                    movieParcel.setTitle(XMLParser.Title.get(position));
                    movieParcel.setRating(XMLParser.Rating.get(position));
                    movieParcel.setGenre(XMLParser.Genre.get(position));
                    movieParcel.setSypnosis(XMLParser.Synopsis.get(position));
                    movieParcel.setCast(XMLParser.Cast.get(position));
                    movieParcel.setMovieIcon(XMLParser.ImageIcon.get(position));
                    movieParcel.setImage(XMLParser.Image.get(position));
                    Intent MovieDataIntent = new Intent(getApplicationContext(), DetailPage.class);

//                String selected = XMLParser.Title.get(position);
//
//                Toast.makeText(getBaseContext(), selected, Toast.LENGTH_SHORT).show();

                    MovieDataIntent.putExtra("details",movieParcel);

                    startActivityForResult(MovieDataIntent, 0);

//                    TempMovie.setTitle(XMLParser.Title.get(position));
//                    TempMovie.setRating(XMLParser.Rating.get(position));
//                    TempMovie.setGenre(XMLParser.Genre.get(position));
//                    TempMovie.setSypnosis(XMLParser.Synopsis.get(position));
//                    TempMovie.setCast(XMLParser.Cast.get(position));
//                    TempMovie.setMovieIcon(XMLParser.ImageIcon.get(position));
//                    TempMovie.setImage(XMLParser.Image.get(position));
//                    MovieList.add(TempMovie);
//                    MovieList.add(TempMovie);

                }
                catch (Exception e)
                {
                    e.getMessage();
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
