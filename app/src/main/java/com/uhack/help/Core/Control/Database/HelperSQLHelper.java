package com.uhack.help.Core.Control.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uhack.help.Core.Model.Comment;
import com.uhack.help.Core.Model.Helper;
import com.uhack.help.Core.Model.Job;
import com.uhack.help.Core.View.Help;

/**
 * Created by Mars on 12/2/2017.
 */

public class HelperSQLHelper extends SQLiteOpenHelper
{

    public static final String NAME  = "helper.db";
    public static final int VERSION  = 1;
    public HelperSQLHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS  "
                + Comment.TAG
                +" ("
                    +Comment.TAG_ID+" TEXT PRIMARY KEY, "
                    +Comment.TAG_DATE+" TEXT, "
                    +Comment.TAG_COMMENT+" TEXT, "
                    +Comment.TAG_POSTER_ID+" INTEGER, "
                    +Comment.TAG_USER_ID+" INTEGER "
                +")");
        db.execSQL("CREATE TABLE IF NOT EXISTS  "
                + Helper.TAG
                +" ("
                +Helper.TAG_ID+" INTEGER PRIMARY KEY, "
                +Helper.TAG_ADDRESS+" TEXT, "
                +Helper.TAG_CITY+" TEXT, "
                +Helper.TAG_CONTACT+" TEXT, "
                +Helper.TAG_EMAIL+" TEXT, "
                +Helper.TAG_FIRSTNAME+" TEXT, "
                +Helper.TAG_MIDDLENAME+" TEXT, "
                +Helper.TAG_LASTNAME+" TEXT, "
                +Helper.TAG_ROLE+" INTEGER "
                +")");
        db.execSQL("CREATE TABLE IF NOT EXISTS  "
                + Job.TAG
                +" ("
                +Job.TAG_ID+" TEXT PRIMARY KEY, "
                +Job.TAG_TITLE+" TEXT, "
                +Job.TAG_ASKER_ID+" TEXT, "
                +Job.TAG_HELPER_ID+" TEXT, "
                +Job.TAG_ACTUAL_COST+" REAL, "
                +Job.TAG_MIN_COST+" REAL, "
                +Job.TAG_MAX_COST+" REAL, "
                +Job.TAG_IMAGE+" TEXT, "
                +Job.TAG_DESCRIPTION+" INTEGER, "
                +Job.TAG_TESTIMONIAL+" INTEGER, "
                +Job.TAG_DATE+" STRING,"
                +Job.TAG_RATE_ASKER+" INTEGER, "
                +Job.TAG_RATE_HELPER+" INTEGER "
                +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
