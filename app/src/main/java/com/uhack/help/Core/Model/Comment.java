package com.uhack.help.Core.Model;

import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment
{
    //==============================================Variable========================================

    public static final String TAG              = "jobcomments";
    public static final String TAG_ID           = "id";
    public static final String TAG_DATE         = "datetime";
    public static final String TAG_COMMENT      = "comment";
    public static final String TAG_USER_ID      = "user_id";
    public static final String TAG_POSTER_ID    = "poster_id";
    public static final String DATE_FORMAT      = "yyyy-MM-dd kk:mm:ss";

    String id;
    Date datetime;
    String comment;
    int user_id;
    int poster_id;

    //==============================================================================================
    public Comment(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            id = object.getString(TAG_ID);
            datetime = new SimpleDateFormat(DATE_FORMAT).parse(object.getString(TAG_DATE));
            comment = object.getString(TAG_COMMENT);
            user_id = object.getInt(TAG_USER_ID);
            poster_id = object.getInt(TAG_POSTER_ID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public Comment(Cursor object)
    {
        try
        {
            id = object.getString(object.getColumnIndex(TAG_ID));
            datetime = new SimpleDateFormat(DATE_FORMAT).parse(object.getString(object.getColumnIndex(TAG_DATE)));
            comment = object.getString(object.getColumnIndex(TAG_COMMENT));
            user_id = object.getInt(object.getColumnIndex(TAG_USER_ID));
            poster_id = object.getInt(object.getColumnIndex(TAG_POSTER_ID));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ContentValues getValues()
    {
        ContentValues values = new ContentValues();
        values.put(TAG_ID,id);
        try
        {
         values.put(TAG_DATE,new SimpleDateFormat(DATE_FORMAT).format(datetime));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        values.put(TAG_COMMENT,comment);
        values.put(TAG_USER_ID,user_id);
        values.put(TAG_POSTER_ID,poster_id);
        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPoster_id() {
        return poster_id;
    }

    public void setPoster_id(int poster_id) {
        this.poster_id = poster_id;
    }
}
