package com.example.lancelotx999.task2;

import android.os.Parcel;
import android.widget.EditText;
import android.os.Parcelable;

/**
 * Created by lancelotx999 on 3/30/15.
 */
public class ImageData implements Parcelable
{
     String ImageName;
     String ImageLocation;
     String ImageKeywords;
     String ImageDate;
     String ImageFounder;
     double ImageRating;


    public ImageData(String Name, String Location, String Keywords, String Date, String Founder,double Rating)
    {
        this.ImageName = Name;
        this.ImageLocation = Location;
        this.ImageKeywords = Keywords;
        this.ImageDate = Date;
        this.ImageFounder = Founder;
        this.ImageRating = Rating;

    }

    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(ImageName);
        out.writeString(ImageLocation);
        out.writeString(ImageKeywords);
        out.writeString(ImageDate);
        out.writeString(ImageFounder);
        out.writeDouble(ImageRating);
    }

    private ImageData(Parcel in)
    {
        ImageName = in.readString();
        ImageLocation = in.readString();
        ImageKeywords = in.readString();
        ImageDate = in.readString();
        ImageFounder = in.readString();
        ImageRating = in.readDouble();
    }

    public int describeContents()
    {
        return 0;
    }

    public static final Parcelable.Creator<ImageData> CREATOR = new Parcelable.Creator<ImageData>()
    {
        public ImageData createFromParcel(Parcel in)
        {
            return new ImageData(in);
        }

        public ImageData[] newArray(int size)
        {
            return new ImageData[size];
        }
    };

}
