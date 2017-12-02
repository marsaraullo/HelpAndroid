package com.uhack.help.Core.Control.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uhack.help.Core.Model.Comment;
import com.uhack.help.Core.View.Help;

import java.util.ArrayList;

/**
 * Created by Mars on 12/2/2017.
 */

public class HelperSQLManager
{
    public void getData()
    {
        ArrayList<Comment> comments = new ArrayList<>();
        SQLiteDatabase database = new HelperSQLHelper(Help.h.getApplicationContext()).getReadableDatabase();
        Cursor cursor = database.query(Comment.TAG,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            do
            {
                comments.add(new Comment(cursor));
            }while (cursor.moveToNext());
        }
        database.close();

    }
    public void saveComments(ArrayList<Comment> comments)
    {

    }
}
