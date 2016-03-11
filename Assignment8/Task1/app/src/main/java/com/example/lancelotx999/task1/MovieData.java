package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lancelotx999 on 5/11/15.
 */
public class MovieData extends BaseAdapter
{
    ArrayList<String> title;
    ArrayList<String> rating;
    ArrayList<String> genre;
    ArrayList<String> sypnosis;
    ArrayList<String> cast;
    ArrayList<String> movieIcon;
    ArrayList<String> image;

    LayoutInflater inflater;

    public MovieData()
    {

    }

    public MovieData(Activity act, ArrayList<String> title, ArrayList<String> rating, ArrayList<String> genre, ArrayList<String> sypnosis, ArrayList<String> cast, ArrayList<String> movieIcon, ArrayList<String> image)
    {
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.sypnosis = sypnosis;
        this.cast = cast;
        this.movieIcon = movieIcon;
        this.image = image;

        inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return title.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder;
        if (convertView == null)
        {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.list_movie, null);
            holder.TextName = (TextView) convertView.findViewById(R.id.TextName);
            holder.TextRating = (TextView) convertView.findViewById(R.id.TextRating);
            holder.TextGenre = (TextView) convertView.findViewById(R.id.TextGenre);
            holder.ImageIcon = (ImageView) convertView.findViewById(R.id.ImgMovie);
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder) convertView.getTag();
        }

        holder.TextName.setText(Html.fromHtml("<b>Title : </b>" + title.get(position)));
        holder.TextRating.setText(Html.fromHtml("<b>Rating : </b>" + rating.get(position)));
        holder.TextGenre.setText(Html.fromHtml("<b>Genre : </b>" + genre.get(position)));

        holder.ImageIcon.setImageResource(R.drawable.furious_icon);


        if (movieIcon.get(position).equals("avenger_icon") == true)
        {
            holder.ImageIcon.setImageResource(R.drawable.avenger_icon);
        }
        else if (movieIcon.get(position).equals("furious_icon.png") == true)
        {
            holder.ImageIcon.setImageResource(R.drawable.furious_icon);
        }
        else if (movieIcon.get(position).equals("ironman_icon") == true)
        {
            holder.ImageIcon.setImageResource(R.drawable.ironman_icon);
        }
        else if (movieIcon.get(position).equals("xmen_icon") == true)
        {
            holder.ImageIcon.setImageResource(R.drawable.xmen_icon);
        }

        return convertView;
    }

    private class Holder
    {
        TextView TextName, TextRating, TextGenre;
        ImageView ImageIcon;
    }
}

