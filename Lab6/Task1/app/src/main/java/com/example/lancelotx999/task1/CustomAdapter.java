package com.example.lancelotx999.task1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Lancelotx999 on 26/4/2015.
 */
public class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] List;

    public CustomAdapter(Context context, int textViewResourceID, String[] List)
    {
        super(context, textViewResourceID, List);
        this.context = context;
        this.List = List;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent)
    {
        View rowView = convertView;

        if(rowView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, parent, false);

        }

        TextView txt = (TextView)rowView.findViewById(R.id.textView);
        txt.setText(List[position]);

        ImageView img = (ImageView)rowView.findViewById(R.id.imageView);
        img.setImageResource(Icons[position]);

        return (rowView);
    }

    private static final Integer[] Icons =
    {
        R.drawable.icon1,
        R.drawable.icon2,
        R.drawable.icon3,
        R.drawable.icon4,
        R.drawable.icon5,
        R.drawable.icon6,
    };

}
