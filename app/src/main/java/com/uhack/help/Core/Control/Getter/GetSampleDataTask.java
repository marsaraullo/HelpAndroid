package com.uhack.help.Core.Control.Getter;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import com.uhack.help.Core.Control.Database.DataInterpreter;
import com.uhack.help.Core.Control.Database.HelperSQLHelper;
import com.uhack.help.Core.Control.Listener.DataListener;
import com.uhack.help.Core.Model.Comment;
import com.uhack.help.Core.Model.Helper;
import com.uhack.help.Core.Model.Job;
import com.uhack.help.Core.View.Help;
import com.uhack.help.R;

import org.json.JSONArray;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Mars on 12/2/2017.
 */

public class GetSampleDataTask extends AsyncTask<Void,Void,Void>
{
    Class c;
    DataListener listener;
    ArrayList<Object> results;
    public GetSampleDataTask(DataListener listener,Class c)
    {
        Log.i("SSSS",""+c.getSimpleName());
        this.listener = listener;
        this.results = new ArrayList<>();
        this.c = c;
    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        InputStream inputStream = Help.h.getApplicationContext().getResources().openRawResource( c== Job.class?R.raw.jobs:c== Comment.class?R.raw.comments:R.raw.helpers);
        String result = DataInterpreter.getData(inputStream);
        Log.i("SSSS",result+"");
        if(c == Job.class)
        {
            try
            {
                JSONArray array = new JSONArray(result);
                for(int ctr=0;ctr<array.length();ctr++)
                {
                    results.add(new Job(array.getString(ctr)));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            SQLiteDatabase database = new HelperSQLHelper(Help.h.getApplicationContext()).getWritableDatabase();
            for (Object o:results)
            {

                Log.i("SSS",((Job)o).getTitle());
                database.insert(Job.TAG,null,((Job)o).getValues());
            }
            database.close();
        }
        else if(c == Comment.class)
        {
            try
            {
                JSONArray array = new JSONArray(result);
                for(int ctr=0;ctr<array.length();ctr++)
                {
                    results.add(new Comment(array.getString(ctr)));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            SQLiteDatabase database = new HelperSQLHelper(Help.h.getApplicationContext()).getWritableDatabase();
            for (Object o:results)
            {

                Log.i("SSS",((Comment)o).getId());
                database.insert(Comment.TAG,null,((Comment)o).getValues());
            }
            database.close();
        }
        else if(c == Helper.class)
        {
            try
            {
                JSONArray array = new JSONArray(result);
                for(int ctr=0;ctr<array.length();ctr++)
                {
                    results.add(new Helper(array.getString(ctr)));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            SQLiteDatabase database = new HelperSQLHelper(Help.h.getApplicationContext()).getWritableDatabase();
            for (Object o:results)
            {

                Log.i("SSS",((Helper)o).getFirstname());
                database.insert(Helper.TAG,null,((Helper)o).getValues());
            }
            database.close();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
