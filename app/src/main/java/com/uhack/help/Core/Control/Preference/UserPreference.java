package com.uhack.help.Core.Control.Preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.uhack.help.Core.Model.Comment;
import com.uhack.help.Core.View.Help;

/**
 * Created by Mars on 12/2/2017.
 */

public class UserPreference
{
    public static final String TAG = "UHACK";
    public static String getUsername()
    {
        SharedPreferences preferences = Help.h.getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);

        return preferences.getString("username","");
    }
    public static void setUsername(String username)
    {
        SharedPreferences preferences = Help.h.getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",username);
        editor.commit();
    }
    public static String getPassword()
    {
        SharedPreferences preferences = Help.h.getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        return preferences.getString("password","");
    }
    public static void setPassword(String password)
    {
        SharedPreferences preferences = Help.h.getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("password",password);
        editor.commit();
    }
}

