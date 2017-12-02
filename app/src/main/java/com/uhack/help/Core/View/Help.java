package com.uhack.help.Core.View;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Mars on 12/2/2017.
 */

public class Help extends Application
{
    public static Help h;
    @Override
    public void onCreate() {
        super.onCreate();
        h = this;
    }
}
