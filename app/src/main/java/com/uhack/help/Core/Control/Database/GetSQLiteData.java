package com.uhack.help.Core.Control.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.uhack.help.Core.Control.Listener.DataListener;
import com.uhack.help.Core.Model.Comment;
import com.uhack.help.Core.Model.Helper;
import com.uhack.help.Core.Model.Job;
import com.uhack.help.Core.View.Help;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mars on 12/2/2017.
 */

public class GetSQLiteData extends AsyncTask<Void,Void,Void>
{

    Class c;
    DataListener dataListener;
    ArrayList<NameValuePair> valuePairs;
    ArrayList<Object> results;

    public GetSQLiteData(Class c,DataListener listener, NameValuePair... query)
    {
        this.c = c;
        this.results = new ArrayList<>();
        this.dataListener = listener;
        this.valuePairs = new ArrayList<>();
        this.valuePairs.addAll(Arrays.asList(query));
    }



    @Override
    protected Void doInBackground(Void... voids)
    {
        SQLiteDatabase db = new HelperSQLHelper(Help.h.getApplicationContext()).getReadableDatabase();
        Cursor c = db.query(getTableName(),null,getFieldNames(),getValues(),null,null,null);
        if(c!=null)
        {
            addResults(c);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(results.size()>0)
        {
            dataListener.dataRetrievedFromLocal(results);
        }
        else
        {
            dataListener.noDataFromLocal();
        }

    }

    public void addResults(Cursor cursor)
    {

        if(c == Job.class)
        {
            if(cursor.moveToFirst())
            {
                do {
                    results.add(new Job(cursor));
                }while (cursor.moveToNext());
            }
        }
        else if(c == Helper.class)
        {
            if(cursor.moveToFirst())
            {
                do {
                    results.add(new Helper(cursor));
                }while (cursor.moveToNext());
            }
        }
        else if(c == Comment.class)
        {
            if(cursor.moveToFirst())
            {
                do {
                    results.add(new Comment(cursor));
                }while (cursor.moveToNext());
            }
        }
    }
    public String getTableName()
    {
        if(c == Job.class)
        {
            return Job.TAG;
        }
        else if(c == Helper.class)
        {
            return Helper.TAG;
        }
        else if(c == Comment.class)
        {
            return Comment.TAG;
        }
        return "UNKNOWN";
    }
    public String getFieldNames()
    {
        String result = "";
        for(NameValuePair nvp:valuePairs)
        {
            if(result.length()>0)
            {
                result+=""+nvp.getKey()+"=?";
            }
            else
            {
                result+=", "+nvp.getKey()+"=?";
            }

        }
        if(result.length()<1)
        {
            return null;
        }
        return result;
    }

    public String[] getValues()
    {
        String[] values = null;

        int ctr =0;
        for(NameValuePair nvp:valuePairs)
        {
            values[ctr] = String.valueOf(nvp.getValue());
            Log.i("SSSS",values[ctr]+"");
            ctr++;
        }
        if(values.length<1)
        {
            return null;
        }
        return values;
    }


}
