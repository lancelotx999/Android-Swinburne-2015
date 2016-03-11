package com.example.lancelotx999.task1;

/**
 * Created by lancelotx999 on 5/11/15.
 */
import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.BaseAdapter;

public class movie implements Parcelable
{

    String title;
    String rating;
    String genre;
    String sypnosis;
    String cast;
    String movieIcon;
    String image;



    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getSypnosis()
    {
        return sypnosis;
    }

    public void setSypnosis(String sypnosis)
    {
        this.sypnosis = sypnosis;
    }

    public String getCast()
    {
        return cast;
    }

    public void setCast(String cast)
    {
        this.cast = cast;
    }

    public String getMovieIcon()
    {
        return movieIcon;
    }

    public void setMovieIcon(String movieIcon)
    {
        this.movieIcon =movieIcon;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String movieImage)
    {
        this.image=movieImage;
    }

    public static final Parcelable.Creator<movie>CREATOR=new Creator<movie>()
    {

        public movie createFromParcel(Parcel source)
        {
            movie movie=new movie();
            movie.title=source.readString();
            movie.sypnosis=source.readString();
            movie.image=source.readString();
            movie.cast=source.readString();
            movie.movieIcon=source.readString();


            return movie;
        }

        public movie[] newArray(int size)
        {

            return new movie[size];
        }

    };

    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void writeToParcel(Parcel parcel, int arg1)
    {
        parcel.writeString(title);
        parcel.writeString(sypnosis);
        parcel.writeString(image);
        parcel.writeString(cast);
        parcel.writeString(movieIcon);


    }

}