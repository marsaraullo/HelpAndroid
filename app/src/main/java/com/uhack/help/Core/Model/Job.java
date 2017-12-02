package com.uhack.help.Core.Model;

import android.content.ContentValues;
import android.database.Cursor;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mars on 12/2/2017.
 */

public class Job
{
    public static final String TAG = "jobposts";
    public static final String TAG_ID = "id";
    public static final String TAG_DATE         = "datetime";
    public static final String TAG_TITLE = "title";
    public static final String TAG_DESCRIPTION = "description";
    public static final String TAG_MIN_COST = "min_cost";
    public static final String TAG_MAX_COST = "max_cost";
    public static final String TAG_ACTUAL_COST = "actual_cost";
    public static final String TAG_ASKER_ID = "asker_id";
    public static final String TAG_HELPER_ID = "helper_id";
    public static final String TAG_RATE_HELPER = "rate_helper";
    public static final String TAG_RATE_ASKER = "rate_asker";
    public static final String TAG_TESTIMONIAL = "testimonial";
    public static final String TAG_IMAGE = "img";
    public static final String DATE_FORMAT      = "yyyy-MM-dd kk:mm:ss";


    String id;
    String title;
    Date datetime;
    String description;
    float min_cost;
    float max_cost;
    float actual_cost;
    int asker_id;
    int helper_id;
    int rate_helper;
    int rate_asker;
    String testimonial;
    String img;

    public Job(String data)
    {
        try
        {
            JSONObject object = new JSONObject(data);
            id = object.getString(TAG_ID);
            title = object.getString(TAG_TITLE);
            description = object.getString(TAG_DESCRIPTION);
            min_cost = object.getLong(TAG_MIN_COST);
            max_cost = object.getLong(TAG_MAX_COST);
            actual_cost = object.getLong(TAG_ACTUAL_COST);
            asker_id = object.getInt(TAG_ASKER_ID);
            helper_id = object.getInt(TAG_HELPER_ID);
            rate_helper= object.getInt(TAG_RATE_HELPER);
            rate_asker= object.getInt(TAG_RATE_ASKER);
            testimonial= object.getString(TAG_TESTIMONIAL);
            img = object.getString(TAG_IMAGE);
            datetime = new SimpleDateFormat(DATE_FORMAT).parse(object.getString(TAG_DATE));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Job(Cursor cursor)
    {
        try
        {
            id = cursor.getString(cursor.getColumnIndex(TAG_ID));
            title = cursor.getString(cursor.getColumnIndex(TAG_TITLE));
            description = cursor.getString(cursor.getColumnIndex(TAG_DESCRIPTION));
            min_cost = cursor.getLong(cursor.getColumnIndex(TAG_MIN_COST));
            max_cost = cursor.getLong(cursor.getColumnIndex(TAG_MAX_COST));
            actual_cost = cursor.getLong(cursor.getColumnIndex(TAG_ACTUAL_COST));
            asker_id = cursor.getInt(cursor.getColumnIndex(TAG_ASKER_ID));
            helper_id = cursor.getInt(cursor.getColumnIndex(TAG_HELPER_ID));
            rate_helper= cursor.getInt(cursor.getColumnIndex(TAG_RATE_HELPER));
            rate_asker= cursor.getInt(cursor.getColumnIndex(TAG_RATE_ASKER));
            testimonial= cursor.getString(cursor.getColumnIndex(TAG_TESTIMONIAL));
            img = cursor.getString(cursor.getColumnIndex(TAG_IMAGE));
            datetime = new SimpleDateFormat(DATE_FORMAT).parse(cursor.getString(cursor.getColumnIndex(TAG_DATE)));
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
        values.put(TAG_TITLE,title);
        values.put(TAG_DESCRIPTION,description);
        values.put(TAG_MIN_COST,min_cost);
        values.put(TAG_MAX_COST,max_cost);
        values.put(TAG_ACTUAL_COST,actual_cost);
        values.put(TAG_ASKER_ID,asker_id);
        values.put(TAG_HELPER_ID,helper_id);
        values.put(TAG_RATE_HELPER,rate_helper);
        values.put(TAG_RATE_ASKER,rate_asker);
        values.put(TAG_TESTIMONIAL,testimonial);
        values.put(TAG_IMAGE,img);
        try
        {
            values.put(TAG_DATE,new SimpleDateFormat(DATE_FORMAT).format(datetime));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getMin_cost() {
        return min_cost;
    }

    public void setMin_cost(float min_cost) {
        this.min_cost = min_cost;
    }

    public float getMax_cost() {
        return max_cost;
    }

    public void setMax_cost(float max_cost) {
        this.max_cost = max_cost;
    }

    public float getActual_cost() {
        return actual_cost;
    }

    public void setActual_cost(float actual_cost) {
        this.actual_cost = actual_cost;
    }

    public int getAsker_id() {
        return asker_id;
    }

    public void setAsker_id(int asker_id) {
        this.asker_id = asker_id;
    }

    public int getHelper_id() {
        return helper_id;
    }

    public void setHelper_id(int helper_id) {
        this.helper_id = helper_id;
    }

    public int getRate_helper() {
        return rate_helper;
    }

    public void setRate_helper(int rate_helper) {
        this.rate_helper = rate_helper;
    }

    public int getRate_asker() {
        return rate_asker;
    }

    public void setRate_asker(int rate_asker) {
        this.rate_asker = rate_asker;
    }

    public String getTestimonial() {
        return testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
