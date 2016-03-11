package com.example.lancelotx999.task1;

/**
 * Created by lancelotx999 on 5/11/15.
 */
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XMLParser extends DefaultHandler
{
    ArrayList<String> Title = new ArrayList<String>();
    ArrayList<String> Rating = new ArrayList<String>();
    ArrayList<String> Genre = new ArrayList<String>();
    ArrayList<String> ImageIcon = new ArrayList<String>();
    ArrayList<String> Image = new ArrayList<String>();
    ArrayList<String> Cast = new ArrayList<String>();
    ArrayList<String> Synopsis = new ArrayList<String>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equalsIgnoreCase("title"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("genre"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("rating"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("image_icon"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("image"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("cast"))
        {
            tempStore = "";
        }
        else if (localName.equalsIgnoreCase("sypnosis"))
        {
            tempStore = "";
        }
        else
        {
            tempStore = "";
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException
    {
        super.endElement(uri, localName, qName);
        if (localName.equalsIgnoreCase("title"))
        {
            Title.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("genre"))
        {
            Genre.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("rating"))
        {
            Rating.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("image_icon"))
        {
            ImageIcon.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("image"))
        {
            Image.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("cast"))
        {
            Cast.add(tempStore);
        }
        else if (localName.equalsIgnoreCase("sypnosis"))
        {
            Synopsis.add(tempStore);
        }
        tempStore = "";
    }

    private String tempStore = "";

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        super.characters(ch, start, length);
        tempStore += new String(ch, start, length);
    }
}