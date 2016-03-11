package com.example.lancelotx999.task2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lancelotx999 on 19/4/2015.
 */
public class UserData implements Parcelable
{
    String UserName;
    String UserEmail;

    public UserData(String Name, String Email)
    {
        this.UserName = Name;
        this.UserEmail = Email;

    }

    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(UserName);
        out.writeString(UserEmail);
    }

    private UserData(Parcel in)
    {
        UserName = in.readString();
        UserEmail = in.readString();
    }

    public int describeContents() {return 0;}

    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>()
    {
        public UserData createFromParcel(Parcel in){return new UserData(in);}

        public UserData[] newArray(int Size){return  new UserData[Size];}

    };

}
